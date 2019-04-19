package mars.Desktop.Component.Functions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import mars.Desktop.Component.Functions.IMARSDesktopDriverCommon.LPPOINT;
import mars.Desktop.Component.Functions.MARSDektopResourceUtil;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

import com.sun.jna.WString;


public class MARSDesktopDriver implements IMARSDektopDriver {

    //private static final Logger log = LoggerFactory.getLogger(AutoIt3.class);
    
    private static final String AUTO_IT_DLL_x86 = "AutoItX3.dll";
    private static final String AUTO_IT_DLL_x64 = "AutoItX3_x64.dll";
    
    final private IMARSDesktopDriverCommon marsDesktopLib;
    

    public MARSDesktopDriver() throws IOException, IllegalStateException {
        if (MARSDektopResourceUtil.isWindows()) {
            System.setProperty("jna.encoding", "UTF16");
            
            String filename;
            if (MARSDektopResourceUtil.is64()) {
                System.out.println("Loading AutoIt x64");
                filename = MARSDektopResourceUtil.copyToTemp(AUTO_IT_DLL_x64, MARSDesktopDriver.class);
            } else {
                System.out.println("Loading AutoIt x86");
                filename = MARSDektopResourceUtil.copyToTemp(AUTO_IT_DLL_x86, MARSDesktopDriver.class);
            }
            
            loadDll(filename);
            
            marsDesktopLib = IMARSDesktopDriverCommon.INSTANCE;
        } else {
            throw new IllegalStateException("OS is not Windows. Unable to load AutoIt library.");
        }
    }
    
    protected static String getAutoItLib() {
        if (MARSDektopResourceUtil.is64()) {
            return AUTO_IT_DLL_x64.replace(".dll", "");
        } else {
            return AUTO_IT_DLL_x86.replace(".dll", "");
        }
    }
    
    
    private void loadDll(String dll) throws IOException {
        try {
            System.out.println("Loading DLL: {}"+ dll);
            System.load(dll);
            System.out.println("Loaded DLL: {}"+ dll);
        } catch (Exception ex) {
            throw new IOException("Failed to load DLL: " + dll, ex);
        }
    }
    
    private WString _w(String s) {
        return new WString(s);
    }
    
    private String byteToString(byte[] byteArray){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int byteCounter = 0;
        while(byteCounter < byteArray.length && byteArray[byteCounter] != 0){
            baos.write(byteArray[byteCounter++]);
        }
        return baos.toString();
    }

    /*
     * =============================================================================================
     *   Implemented Methods
     * =============================================================================================
     */
    
    @Override
    public void marsInit() {
        marsDesktopLib.AU3_Init();
    }

    @Override
    public int marsError() {
        return marsDesktopLib.AU3_error();
    }

    @Override
    public int marsDesktopSetOption(String option, int value) {
        return marsDesktopLib.AU3_AutoItSetOption(_w(option), value);
    }

    @Override
    public void marsBlockInput(int flag) {
        marsDesktopLib.AU3_BlockInput(flag);
    }

    @Override
    public void marsCdTray(String drive, String action) {
        marsDesktopLib.AU3_CDTray(_w(drive), _w(action));
    }

    @Override
    public void marsClipGet(byte[] clip, int bufSize) {
        marsDesktopLib.AU3_ClipGet(clip, bufSize);
    }

    @Override
    public void marsClipPut(String clip) {
        marsDesktopLib.AU3_ClipPut(_w(clip));
    }

    @Override
    public void marsControlClick(String title, String text, String control, String button, int numClicks, int x, int y) {
        if (marsDesktopLib.AU3_ControlClick(_w(title), _w(text), _w(control), _w(button), numClicks, x, y) == 0) {
            throw new MARSDektopDriverException("Failed to click control '"+ control +"' on window '"+ title +"'");
        }
    }

    @Override
    public void marsControlClick(String title, String text, String control) {
        marsControlClick(title, text, control, "left", 1, 1, 1);
    }

    @Override
    public void marsControlCommand(String title, String text, String control, String command, String extra, byte[] result, int bufSize) {
        marsDesktopLib.AU3_ControlCommand(_w(title), _w(text), _w(control), _w(command), _w(extra), result, bufSize);
        
    }

    @Override
    public void marsControlListView(String title, String text, String control, String command, String extra1, String extra2, byte[] result, int bufSize) {
        marsDesktopLib.AU3_ControlListView(_w(title), _w(text), _w(control), _w(command), _w(extra1), _w(extra2), result, bufSize);
    }

    @Override
    public int marsControlDisable(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlDisable(_w(title), _w(text), _w(control));
    }

    @Override
    public int marsControlEnable(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlEnable(_w(title), _w(text), _w(control));
    }

    @Override
    public int marsControlFocus(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlFocus(_w(title), _w(text), _w(control));
    }

    @Override
    public void marsControlGetFocus(String title, String text, byte[] controlWithFocus, int bufSize) {
        marsDesktopLib.AU3_ControlGetFocus(_w(title), _w(text), controlWithFocus, bufSize);
    }

    @Override
    public void marsControlGetHandle(String title, String text, String control, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_ControlGetHandle(_w(title), _w(text), _w(control), retText, bufSize);
    }

    @Override
    public int marsControlGetPosX(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlGetPosX(_w(title), _w(text), _w(control));
    }

    @Override
    public int marsControlGetPosY(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlGetPosY(_w(title), _w(text), _w(control));
    }

    @Override
    public int marsControlGetPosHeight(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlGetPosHeight(_w(title), _w(text), _w(control));
    }

    @Override
    public int marsControlGetPosWidth(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlGetPosWidth(_w(title), _w(text), _w(control));
    }

    @Override
    public void marsControlGetText(String title, String text, String control, byte[] controlText, int bufSize) {
        marsDesktopLib.AU3_ControlGetText(_w(title), _w(text), _w(control), controlText, bufSize);
    }
    
    @Override
    public String marsControlGetText(String title, String text, String control) {
        int bufSize = 2048;
        byte[] bytes = new byte[bufSize];
        marsControlGetText(title, text, control, bytes, bufSize);
        return byteToString(bytes);
    }

    @Override
    public int marsControlHide(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlHide(_w(title), _w(text), _w(control));
    }

    @Override
    public int marsControlMove(String title, String text, String control, int x, int y, int width, int height) {
        return marsDesktopLib.AU3_ControlMove(_w(title), _w(text), _w(control), x, y, width, height);
    }

    @Override
    public int marsControlSend(String title, String text, String control, String sendText, int mode) {
        return marsDesktopLib.AU3_ControlSend(_w(title), _w(text), _w(control), _w(sendText), mode);
    }

    @Override
    public int marsControlSend(String title, String text, String control, String sendText) {
        return marsControlSend(title, text, control, sendText, 0);
    }

    @Override
    public int marsControlSetText(String title, String text, String control, String controlText) {
        return marsDesktopLib.AU3_ControlSetText(_w(title), _w(text), _w(control), _w(controlText));
    }

    @Override
    public int marsControlShow(String title, String text, String control) {
        return marsDesktopLib.AU3_ControlShow(_w(title), _w(text), _w(control));
    }

    @Override
    public void marsDriveMapAdd(String device, String share, int flags, String user, String pwd, byte[] result, int bufSize) {
        marsDesktopLib.AU3_DriveMapAdd(_w(device), _w(share), flags, _w(user), _w(pwd), result, bufSize);
    }

    @Override
    public int marsDriveMapDel(String device) {
        return marsDesktopLib.AU3_DriveMapDel(_w(device));
    }

    @Override
    public void marsDriveMapGet(String device, byte[] mapping, int bufSize) {
        marsDesktopLib.AU3_DriveMapGet(_w(device), mapping, bufSize);
    }

    @Override
    public int marsINIDelete(String filename, String section, String key) {
        return marsDesktopLib.AU3_IniDelete(_w(filename), _w(section), _w(key));
    }

    @Override
    public void marsINIRead(String filename, String section, String key, String defaultValue, byte[] value, int bufSize) {
        marsDesktopLib.AU3_IniRead(_w(filename), _w(section), _w(key), _w(defaultValue), value, bufSize);
    }

    @Override
    public int marsINIWrite(String filename, String section, String key, String value) {
        return marsDesktopLib.AU3_IniWrite(_w(filename), _w(section), _w(key), _w(value));
    }

    @Override
    public int marsIsAdmin() {
        return marsDesktopLib.AU3_IsAdmin();
    }

    @Override
    public int marsMouseClick(String button, int x, int y, int clicks, int speed) {
        return marsDesktopLib.AU3_MouseClick(_w(button), x, y, clicks, speed);
    }

    @Override
    public int marsMouseClickDrag(String button, int x1, int y1, int x2, int y2, int speed) {
        return marsDesktopLib.AU3_MouseClickDrag(_w(button), x1, y1, x2, y2, speed);
    }

    @Override
    public void marsMouseDown(String button) {
        marsDesktopLib.AU3_MouseDown(_w(button));
    }

    @Override
    public int marsMouseGetCursor() {
        return marsDesktopLib.AU3_MouseGetCursor();
    }

    @Override
    public int marsMouseGetPosX() {
        return marsDesktopLib.AU3_MouseGetPosX();
    }

    @Override
    public int marsMouseGetPosY() {
        return marsDesktopLib.AU3_MouseGetPosY();
    }

    @Override
    public int marsMouseMove(int x, int y, int speed) {
        return marsDesktopLib.AU3_MouseMove(x, y, speed);
    }

    @Override
    public void marsMouseUp(String button) {
        marsDesktopLib.AU3_MouseUp(_w(button));
    }

    @Override
    public void marsMouseWheel(String direction, int clicks) {
        marsDesktopLib.AU3_MouseWheel(_w(direction), clicks);
    }

    @Override
    public int marsOpt(String option, int value) {
        return marsDesktopLib.AU3_Opt(_w(option), value);
    }

    @Override
    public int marsPixelChecksum(int left, int top, int right, int bottom, int step) {
        return marsDesktopLib.AU3_PixelChecksum(left, top, right, bottom, step);
    }

    @Override
    public int marsPixelGetColor(int x, int y) {
        return marsDesktopLib.AU3_PixelGetColor(x, y);
    }

    @Override
    public void marsPixelSearch(int left, int top, int right, int bottom, int col, int var, int step, LPPOINT pointResult) {
        marsDesktopLib.AU3_PixelSearch(left, top, right, bottom, col, var, step, pointResult);
    }

    @Override
    public int marsProcessClose(String process) {
        return marsDesktopLib.AU3_ProcessClose(_w(process));
    }

    @Override
    public int marsProcessExists(String process) {
        return marsDesktopLib.AU3_ProcessExists(_w(process));
    }

    @Override
    public int marsProcessSetPriority(String process, int priority) {
        return marsDesktopLib.AU3_ProcessSetPriority(_w(process), priority);
    }

    @Override
    public int marsProcessWait(String process, int timeout) {
        return marsDesktopLib.AU3_ProcessWait(_w(process), timeout);
    }

    @Override
    public int marsProcessWaitClose(String process, int timeout) {
        return marsDesktopLib.AU3_ProcessWaitClose(_w(process), timeout);
    }

    @Override
    public int marsRegDeleteKey(String keyname) {
        return marsDesktopLib.AU3_RegDeleteKey(_w(keyname));
    }

    @Override
    public int marsRegDeleteVal(String keyname, String valueName) {
        return marsDesktopLib.AU3_RegDeleteVal(_w(keyname), _w(valueName));
    }

    @Override
    public void marsRegEnumKey(String keyname, int instance, byte[] result, int bufSize) {
        marsDesktopLib.AU3_RegEnumKey(_w(keyname), instance, result, bufSize);
    }

    @Override
    public void marsRegEnumVal(String keyname, int instance, byte[] result, int bufSize) {
        marsDesktopLib.AU3_RegEnumVal(_w(keyname), instance, result, bufSize);
    }

    @Override
    public void marsRegRead(String keyname, String valueName, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_RegRead(_w(keyname), _w(valueName), retText, bufSize);
    }

    @Override
    public int marsRegWrite(String keyname, String valueName, String type, String value) {
        return marsDesktopLib.AU3_RegWrite(_w(keyname), _w(valueName), _w(type), _w(value));
    }

    @Override
    public int marsRun(String run, String dir, int showFlags) {
        return marsDesktopLib.AU3_Run(_w(run), _w(dir), showFlags);
    }
    
    @Override
    public int marsRun(String run) {
        return marsRun(run, "", 1);
    }

    @Override
    public int marsRunAsSet(String user, String domain, String password, int options) {
        return marsDesktopLib.AU3_RunAsSet(_w(user), _w(domain), _w(password), options);
    }

    @Override
    public int marsRunWait(String run, String dir, int showFlags) {
        return marsDesktopLib.AU3_RunWait(_w(run), _w(dir), showFlags);
    }

    @Override
    public void marsSend(String sendText, int mode) {
        marsDesktopLib.AU3_Send(_w(sendText), mode);
    }

    @Override
    public int marsShutdown(int flags) {
        return marsDesktopLib.AU3_Shutdown(flags);
    }

    @Override
    public void marsSleep(int milliseconds) {
        marsDesktopLib.AU3_Sleep(milliseconds);
    }

    @Override
    public void marsStatusbarGetText(String title, String text, int part, byte[] statusText, int bufSize) {
        marsDesktopLib.AU3_StatusbarGetText(_w(title), _w(text), part, statusText, bufSize);
    }

    @Override
    public void marsToolTip(String tip, int x, int y) {
        marsDesktopLib.AU3_ToolTip(_w(tip), x, y);
    }

    @Override
    public int marsWinActive(String title, String text) {
        return marsDesktopLib.AU3_WinActive(_w(title), _w(text));
    }

    @Override
    public void marsWinActivate(String title, String text) {
        marsDesktopLib.AU3_WinActivate(_w(title), _w(text));
    }

    @Override
    public int marsWinClose(String title, String text) {
        return marsDesktopLib.AU3_WinClose(_w(title), _w(text));
    }

    @Override
    public int marsWinExists(String title, String text) {
        return marsDesktopLib.AU3_WinExists(_w(title), _w(text));
    }

    @Override
    public int marsWinGetCaretPosX() {
        return marsDesktopLib.AU3_WinGetCaretPosX();
    }

    @Override
    public int marsWinGetCaretPosY() {
        return marsDesktopLib.AU3_WinGetCaretPosY();
    }

    @Override
    public void marsWinGetClassList(String title, String text, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_WinGetClassList(_w(title), _w(text), retText, bufSize);
    }

    @Override
    public int marsWinGetClientSizeHeight(String title, String text) {
        return marsDesktopLib.AU3_WinGetClientSizeHeight(_w(title), _w(text));
    }

    @Override
    public int marsWinGetClientSizeWidth(String title, String text) {
        return marsDesktopLib.AU3_WinGetClientSizeWidth(_w(title), _w(text));
    }

    @Override
    public void marsWinGetHandle(String title, String text, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_WinGetHandle(_w(title), _w(text), retText, bufSize);
    }

    @Override
    public int marsWinGetPosX(String title, String text) {
        return marsDesktopLib.AU3_WinGetPosX(_w(title), _w(text));
    }

    @Override
    public int marsWinGetPosY(String title, String text) {
        return marsDesktopLib.AU3_WinGetPosY(_w(title), _w(text));
    }

    @Override
    public int marsWinGetPosHeight(String title, String text) {
        return marsDesktopLib.AU3_WinGetPosHeight(_w(title), _w(text));
    }

    @Override
    public int marsWinGetPosWidth(String title, String text) {
        return marsDesktopLib.AU3_WinGetPosWidth(_w(title), _w(text));
    }

    @Override
    public void marsWinGetProcess(String title, String text, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_WinGetProcess(_w(title), _w(text), retText, bufSize);
    }

    @Override
    public int marsWinGetState(String title, String text) {
        return marsDesktopLib.AU3_WinGetState(_w(title), _w(text));
    }

    @Override
    public void marsWinGetText(String title, String text, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_WinGetText(_w(title), _w(text), retText, bufSize);
    }
    
    @Override
    public String marsWinGetText(String title, String text) {
        int bufSize = 2048;
        byte[] bytes = new byte[bufSize];
        marsWinGetText(title, text, bytes, bufSize);
        return byteToString(bytes);
    }

    @Override
    public void marsWinGetTitle(String title, String text, byte[] retText, int bufSize) {
        marsDesktopLib.AU3_WinGetTitle(_w(title), _w(text), retText, bufSize);
    }
    
    @Override
    public String marsWinGetTitle(String title, String text) {
        int bufSize = 2048;
        byte[] bytes = new byte[bufSize];
        marsWinGetTitle(title, text, bytes, bufSize);
        return byteToString(bytes);
    }

    @Override
    public int marsWinKill(String title, String text) {
        return marsDesktopLib.AU3_WinKill(_w(title), _w(text));
    }

    @Override
    public int marsWinMenuSelectItem(String title, String text, String item1, String item2, String item3, String item4, String item5, String item6, String item7, String item8) {
        return marsDesktopLib.AU3_WinMenuSelectItem(_w(title), _w(text), _w(item1), _w(item2), _w(item3), _w(item4), _w(item5), _w(item6), _w(item7), _w(item8));
    }

    @Override
    public void marsWinMinimizeAll() {
        marsDesktopLib.AU3_WinMinimizeAll();
    }

    @Override
    public void marsWinMinimizeAllUndo() {
        marsDesktopLib.AU3_WinMinimizeAllUndo();
    }

    @Override
    public int marsWinMove(String title, String text, int x, int y, int width, int height) {
        return marsDesktopLib.AU3_WinMove(_w(title), _w(text), x, y, width, height);
    }

    @Override
    public int marsWinSetOnTop(String title, String text, int flag) {
        return marsDesktopLib.AU3_WinSetOnTop(_w(title), _w(text), flag);
    }

    @Override
    public int marsWinSetState(String title, String text, int flags) {
        return marsDesktopLib.AU3_WinSetState(_w(title), _w(text), flags);
    }

    @Override
    public int marsWinSetTitle(String title, String text, String newTitle) {
        return marsDesktopLib.AU3_WinSetTitle(_w(title), _w(text), _w(newTitle));
    }

    @Override
    public int marsWinSetTrans(String title, String text, int trans) {
        return marsDesktopLib.AU3_WinSetTrans(_w(title), _w(text), trans);
    }

    @Override
    public int marsWinWait(String title, String text, int timeout) {
        return marsDesktopLib.AU3_WinWait(_w(title), _w(text), timeout);
    }

    @Override
    public int marsWinWaitActive(String title, String text, int timeout) {
        return marsDesktopLib.AU3_WinWaitActive(_w(title), _w(text), timeout);
    }

    @Override
    public int marsWinWaitClose(String title, String text, int timeout) {
        return marsDesktopLib.AU3_WinWaitClose(_w(title), _w(text), timeout);
    }

    @Override
    public int marsWinWaitNotActive(String title, String text, int timeout) {
        return marsDesktopLib.AU3_WinWaitNotActive(_w(title), _w(text), timeout);
    }
    
}
