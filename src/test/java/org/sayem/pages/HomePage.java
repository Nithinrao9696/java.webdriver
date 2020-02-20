public class GridExample {
     
    @Test
    public void mailTest() throws MalformedURLException{
        DesiredCapabilities dr=null;
        if(browserType.equals("firefox")){
        dr=DesiredCapabilities.firefox();
        dr.setBrowserName("firefox");
        dr.setPlatform(Platform.WINDOWS);
     
        }else{
            dr=DesiredCapabilities.internetExplorer();
            dr.setBrowserName("iexplore");
            dr.setPlatform(Platform.WINDOWS);
        }
             
        RemoteWebDriver driver=new RemoteWebDriver(new    URL("http://ap-jenkdx-dev:4444/wd/hub"), dr);
        driver.navigate().to("http://gmail.com");
        driver.findElement(By.xpath("//input[@id='Email']")) .sendKeys("username");
        driver.findElement(By.xpath("//input[@id='Passwd']")) .sendKeys("password");
        driver.close();
     
}
