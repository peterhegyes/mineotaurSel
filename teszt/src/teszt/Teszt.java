/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teszt;

import static bsh.ParserConstants.EOF;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Hegyes Péter
 */
public class Teszt {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Teszt genewisescatterplot = new Teszt();
        Teszt genewisedistribution = new Teszt();
        Teszt cellwisescatterplot = new Teszt();
        Teszt cellwisedistribution = new Teszt();
        
        //genewisescatterplot.genewisescatterplot();
        genewisedistribution.genewisedistribution();
        cellwisescatterplot.cellwisescatterplot();
        cellwisedistribution.cellwisedistribution();
        
    }
    public void genewisescatterplot(){
        WebDriver objdriver = new FirefoxDriver();
        objdriver.get("http://demo.mineotaur.org");
                
        Select objSelect = new Select(objdriver.findElement(By.id("prop1")));
        WebElement prop1 = objdriver.findElement(By.id("prop1"));
        
        Select objSelect2 = new Select(objdriver.findElement(By.id("aggProp1")));
        WebElement aggprop1 = objdriver.findElement(By.id("aggProp1"));
        
       List<WebElement> prop1options = prop1.findElements(By.tagName("option"));
       List<WebElement> aggprop1options = aggprop1.findElements(By.tagName("option"));
       for(int i=0; i<prop1options.size(); i++){
           objSelect.selectByIndex(i);
        for(int j=0; j<aggprop1options.size(); j++){
            objSelect2.selectByIndex(j);
            //objdriver.findElement(By.id("graphFormSubmit")).click();
            //objdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }
          }
       objdriver.close();
    }
    
    public void genewisedistribution(){
        WebDriver objdriver = new FirefoxDriver();
        objdriver.get("http://demo.mineotaur.org");
        
         objdriver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS); 
         objdriver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS); 

        
        WebElement elementLinkCheck = objdriver.findElement(By.xpath("//ul[@class='mail-links']")); 
        List<WebElement> listElementLinkCheck = objdriver.findElements(By.xpath("//ul[@class='nav navbar-nav']")); 

        for(WebElement element : listElementLinkCheck ) { 
            System.out.println("Element inside ul -->" + element.getText()); 
            System.out.println("Attrbite for that element-->" + element.getTagName()); 
            if("Gene-wise distribution".equalsIgnoreCase(element.getText())){ 
                System.out.println("Create account is identified.-->" + element.getText()); 
                element.click(); 
            }
        }

        Select objSelect = new Select(objdriver.findElement(By.id("propGWDist")));
        WebElement propGWDist = objdriver.findElement(By.id("propGWDist"));
        
        Select objSelect2 = new Select(objdriver.findElement(By.id("aggGWDist")));
        WebElement aggGWDist = objdriver.findElement(By.id("aggGWDist"));
        
        Select objSelect3 = new Select(objdriver.findElement(By.id("genewisePlotType")));
        WebElement genewisePlotType = objdriver.findElement(By.id("genewisePlotType"));
        
       List<WebElement> propGWDistoptions = propGWDist.findElements(By.tagName("option"));
       List<WebElement> aggGWDistoptions = aggGWDist.findElements(By.tagName("option"));
       List<WebElement> genewisePlotTypeoptions = genewisePlotType.findElements(By.tagName("option"));
       
       for(int i=0; i<propGWDistoptions.size(); i++){
           objSelect.selectByIndex(i);
        for(int j=0; j<aggGWDistoptions.size(); j++){
            objSelect2.selectByIndex(j);
            for(int k=0; k<genewisePlotTypeoptions.size(); k++){
                objSelect3.deselectByIndex(k);
                objdriver.findElement(By.id("genewiseDistributionSubmit")).click();
                //WebDriverWait webDriverWait = new WebDriverWait(objdriver, 10);
            }
           }
          }
       objdriver.close();
    }
    
    public void cellwisescatterplot(){
        WebDriver objdriver = new FirefoxDriver();
        objdriver.get("http://demo.mineotaur.org");

        Select objSelect = new Select(objdriver.findElement(By.id("cellwiseProp1")));
        WebElement cellwiseProp1 = objdriver.findElement(By.id("cellwiseProp1"));
        
        Select objSelect2 = new Select(objdriver.findElement(By.id("cellwiseProp2")));
        WebElement cellwiseProp2 = objdriver.findElement(By.id("cellwiseProp2"));
        
        Select objSelect3 = new Select(objdriver.findElement(By.id("geneCWProp1")));
        WebElement geneCWProp1 = objdriver.findElement(By.id("geneCWProp1"));
        
       List<WebElement> cellwiseProp1options = cellwiseProp1.findElements(By.tagName("option"));
       List<WebElement> cellwiseProp2options = cellwiseProp2.findElements(By.tagName("option"));
       List<WebElement> geneCWProp1options = geneCWProp1.findElements(By.tagName("option"));
       
       for(int i=0; i<cellwiseProp1options.size(); i++){
           objSelect.selectByIndex(i);
        for(int j=0; j<cellwiseProp2options.size(); j++){
            objSelect2.selectByIndex(j);
            for(int k=0; k<geneCWProp1options.size(); k++){
                objSelect3.selectByIndex(k);
            //objdriver.findElement(By.id("cellwiseGraphSubmit")).click();
            //WebDriverWait webDriverWait = new WebDriverWait(objdriver, 10);
            }
            }
          }
       objdriver.close();
    }
    public void cellwisedistribution(){
         WebDriver objdriver = new FirefoxDriver();
        objdriver.get("http://demo.mineotaur.org");

        Select objSelect = new Select(objdriver.findElement(By.id("geneCWDist")));
        WebElement geneCWDist = objdriver.findElement(By.id("geneCWDist"));
        
        Select objSelect2 = new Select(objdriver.findElement(By.id("propCWDist")));
        WebElement propCWDist = objdriver.findElement(By.id("propCWDist"));
        
        Select objSelect3 = new Select(objdriver.findElement(By.id("cellwisePlotType")));
        WebElement cellwisePlotType = objdriver.findElement(By.id("cellwisePlotType"));
        
       List<WebElement> geneCWDistoptions = geneCWDist.findElements(By.tagName("option"));
       List<WebElement> propCWDistoptions = propCWDist.findElements(By.tagName("option"));
       List<WebElement> cellwisePlotTypeoptions = cellwisePlotType.findElements(By.tagName("option"));
       
       for(int i=0; i<geneCWDistoptions.size(); i++){
           objSelect.selectByIndex(i);
        for(int j=0; j<propCWDistoptions.size(); j++){
            objSelect2.selectByIndex(j);
            for(int k=0; k<cellwisePlotTypeoptions.size(); k++){
                objSelect3.selectByIndex(k);
            //objdriver.findElement(By.id("cellwiseDistributionSubmit")).click();
            //WebDriverWait webDriverWait = new WebDriverWait(objdriver, 10);
            }
            }
          }
       objdriver.close();
    }
}
   
