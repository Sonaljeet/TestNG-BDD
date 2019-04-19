package mars.Desktop.Component.Functions;

import mars.Desktop.Component.Functions.IMARSDesktopDriverCommon.LPPOINT;

public interface IMARSDektopDriver {
    
    
    public void marsInit();
    
    public int marsError();
    
    public int marsDesktopSetOption(String option, int value);
    
    public void marsBlockInput(int flag);
    
    public void marsCdTray(String drive, String action);
    
    public void marsClipGet(byte[] clip, int bufSize);
    
    public void marsClipPut(String clip);
    
    public void marsControlClick(String title, String text, String control, String button, int numClicks, int x, int y);
    public void marsControlClick(String title, String text, String control);
    
    public void marsControlCommand(String title, String text, String control, String command, String extra, byte[] result, int bufSize);
    
    public void marsControlListView(String title, String text, String control, String command, String extra1, String extra2, byte[] result, int bufSize);
    
    public int marsControlDisable(String title, String text, String control);
    
    public int marsControlEnable(String title, String text, String control);
    
    public int marsControlFocus(String title, String text, String control);
    
    public void marsControlGetFocus(String title, String text, byte[] controlWithFocus, int bufSize);
    
    public void marsControlGetHandle(String title, String text, String control, byte[] retText, int bufSize);
    
    public int marsControlGetPosX(String title, String text, String control);
    
    public int marsControlGetPosY(String title, String text, String control);
    
    public int marsControlGetPosHeight(String title, String text, String control);
    
    public int marsControlGetPosWidth(String title, String text, String control);
    
    public void marsControlGetText(String title, String text, String control, byte[] controlText, int bufSize);
    public String marsControlGetText(String title, String text, String control);
    
    public int marsControlHide(String title, String text, String control);
    
    public int marsControlMove(String title, String text, String control, int x, int y, int width, int height);
    
    public int marsControlSend(String title, String text, String control, String sendText, int mode);
    public int marsControlSend(String title, String text, String control, String sendText);
    
    public int marsControlSetText(String title, String text, String control, String controlText);
    
    public int marsControlShow(String title, String text, String control);
    
    public void marsDriveMapAdd(String device, String szShare, int flags, String user, String pwd, byte[] result, int bufSize);
    
    public int marsDriveMapDel(String device);
    
    public void marsDriveMapGet(String device, byte[] mapping, int bufSize);
    
    public int marsINIDelete(String filename, String section, String key);
    
    public void marsINIRead(String filename, String section, String key, String defaultValue, byte[] value, int bufSize);
    
    public int marsINIWrite(String filename, String section, String key, String value);
    
    public int marsIsAdmin();
    
    public int marsMouseClick(String button, int x, int y, int clicks, int speed);
    
    public int marsMouseClickDrag(String button, int x1, int y1, int x2, int y2, int speed);
    
    public void marsMouseDown(String button);
    
    public int marsMouseGetCursor();
    
    public int marsMouseGetPosX();
    
    public int marsMouseGetPosY();
    
    public int marsMouseMove(int x, int y, int speed);
    
    public void marsMouseUp(String button);
    
    public void marsMouseWheel(String direction, int clicks);
    
    public int marsOpt(String option, int value);
    
    public int marsPixelChecksum(int left, int top, int right, int bottom,  int step);
    
    public int marsPixelGetColor(int x, int y);
    
    public void marsPixelSearch(int left, int top, int right, int bottom, int col,  int var,  int step, LPPOINT pointResult);
    
    public int marsProcessClose(String process);
    
    public int marsProcessExists(String process);
    
    public int marsProcessSetPriority(String process, int priority);
    
    public int marsProcessWait(String process, int timeout);
    
    public int marsProcessWaitClose(String process, int timeout);
    
    public int marsRegDeleteKey(String keyname);
    
    public int marsRegDeleteVal(String keyname, String valueName);
    
    public void marsRegEnumKey(String keyname, int instance, byte[] result, int bufSize);
    
    public void marsRegEnumVal(String keyname, int instance, byte[] result, int bufSize);
    
    public void marsRegRead(String keyname, String valuename, byte[] retText, int bufSize);
    
    public int marsRegWrite(String keyname, String valuename, String type, String value);
    
    public int marsRun(String run, String dir, int showFlags);
    public int marsRun(String run);
    
    public int marsRunAsSet(String user, String domain, String password, int options);
    
    public int marsRunWait(String run, String dir, int showFlags);
    
    public void marsSend(String szSendText, int mode);
    
    public int marsShutdown(int flags);
    
    public void marsSleep(int milliseconds);
    
    public void marsStatusbarGetText(String title, String text, int part, byte[] statusText, int bufSize);
    
    public void marsToolTip(String tip, int x, int y);
    
    public int marsWinActive(String title, String text);
    
    public void marsWinActivate(String title, String text);
    
    public int marsWinClose(String title, String text);
    
    public int marsWinExists(String title, String text);
    
    public int marsWinGetCaretPosX();
    
    public int marsWinGetCaretPosY();
    
    public void marsWinGetClassList(String title, String text, byte[] retText, int bufSize);
    
    public int marsWinGetClientSizeHeight(String title, String text);
    
    public int marsWinGetClientSizeWidth(String title, String text);
    
    public void marsWinGetHandle(String title, String text, byte[] retText, int bufSize);
    
    public int marsWinGetPosX(String title, String text);
    
    public int marsWinGetPosY(String title, String text);
    
    public int marsWinGetPosHeight(String title, String text);
    
    public int marsWinGetPosWidth(String title, String text);
    
    public void marsWinGetProcess(String title, String text, byte[] retText, int bufSize);
    
    public int marsWinGetState(String title, String text);
    
    public void marsWinGetText(String title, String text, byte[] retText, int bufSize);
    public String marsWinGetText(String title, String text);
    
    public void marsWinGetTitle(String title, String text, byte[] retText, int bufSize);
    public String marsWinGetTitle(String title, String text);
    
    public int marsWinKill(String title, String text);
    
    public int marsWinMenuSelectItem(String title, String text, String item1, String item2, String item3, String item4, String item5, String item6, String item7, String item8);
    
    public void marsWinMinimizeAll();
    
    public void marsWinMinimizeAllUndo();
    
    public int marsWinMove(String title, String text, int x, int y, int width, int height);
    
    public int marsWinSetOnTop(String title, String text, int flag);
    
    public int marsWinSetState(String title, String text, int flags);
    
    public int marsWinSetTitle(String title, String text, String newTitle);
    
    public int marsWinSetTrans(String title, String text, int trans);
    
    public int marsWinWait(String title, String text, int timeout);
    
    public int marsWinWaitActive(String title, String text, int timeout);
    
    public int marsWinWaitClose(String title, String text, int timeout);
    
    public int marsWinWaitNotActive(String title, String text, int timeout);

}
