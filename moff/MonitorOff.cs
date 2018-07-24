public static class MonitorOff {

  [System.Runtime.InteropServices.DllImport("user32.dll")]
  private static extern int SendMessage(int hWnd, uint Msg, int wParam, int lParam);
  private const int WM_SYSCOMMAND = 0x112;
  private const int SC_MONITORPOWER = 0xf170;

  public static void Main() {
    SendMessage(-1, WM_SYSCOMMAND, SC_MONITORPOWER, 2); 
  }
}