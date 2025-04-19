public class PunchInTest extends BaseTest 
{
    public void verifyPunchInToast() 
  {
        LoginPage login = new LoginPage(driver);
        login.login("admin@test.com", "Admin@123");

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickPunchIn();
        String toastMessage = dashboard.getToastMessage();
        Assert.assertEquals(toastMessage, "Punch In Successfully");
    }
}
