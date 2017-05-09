/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teszt;

import java.util.List;                                                                              // a lista csomag importalasa
import java.util.concurrent.TimeUnit;                                                               // a TimeUnit csomag importalasa
import static java.util.concurrent.TimeUnit.SECONDS;
import org.openqa.selenium.By;                                                                      // a By csomag importalalasa
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;                                                               // a WebDriver csomag importalasa
import org.openqa.selenium.WebElement;                                                              // a WebElement csomag importalasa
import org.openqa.selenium.firefox.FirefoxDriver;                                                   // a FirefoxDriver csomag importalasa
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;                                                       // a Select csomag importalasa
import org.openqa.selenium.support.ui.Wait;

/**
 *
 * @author Hegyes Péter
 */
public class Teszt {
    /**
     * @param args the command line arguments
     */
    
   public static WebDriver objdriver = new FirefoxDriver();                                        // Egy publikus WebDriver deklaralasa, amely FirefoxDriver
    
    public static void main(String[] args) {
        
        frame fr = new frame();
    


        objdriver.get("http://193.62.54.68:1980/mineotaur/");                                       // A WebDriver-rel megnyitjuk a http://193.62.54.68:1980/mineotaur/ -t
          
        Teszt genewisescatterplot = new Teszt();                                                    // Letrehozom a Teszt tipusu genewisescatterplot nevu valtozot
        Teszt genewisedistribution = new Teszt();                                                   // Letrehozom a Teszt tipusu genewisedistribution nevu valtozot
        Teszt cellwisescatterplot = new Teszt();                                                    // Letrehozom a Teszt tipusu cellwisescatterplot nevu valtozot
        Teszt cellwisedistribution = new Teszt();                                                   // Letrehozom a Teszt tipusu cellwisedistribution nevu valtozot
        
        //genewisescatterplot.genewisescatterplot();                                                  // Meghivom a genewisescatterplot() nevu eljarast
        //genewisedistribution.genewisedistribution();                                                // Meghivom a genewisedistribution() nevu eljarast
        //cellwisescatterplot.cellwisescatterplot();                                                  // Meghivom a cellwisescatterplot() nevu eljarast
        //cellwisedistribution.cellwisedistribution();                                                // Meghivom a cellwisedistribution() nevu eljarast
       
    }

    public static void genewisescatterplot() throws InterruptedException{                                                              // Letrehoztam a genewisescatterplot() nevu eljarast
              
       Select objSelect = new Select(objdriver.findElement(By.id("prop1")));                        // Letrehoztam egy Select tipusu valtozot, amely a "prop1" nevu elemet keresi meg a weblapon
       WebElement prop1 = objdriver.findElement(By.id("prop1"));                                    // Letrehoztam egy WebElement tipusu valtozot, amely a "prop1" nevu weblap elem lesz
        
       Select objSelect2 = new Select(objdriver.findElement(By.id("aggProp1")));                    // Letrehoztam egy Select tipusu valtozot, amely a "aggprop1" nevu elemet keresi meg a weblapon
       WebElement aggprop1 = objdriver.findElement(By.id("aggProp1"));                              // Letrehoztam egy WebElement tipusu valtozot, amely a "aggprop1" nevu weblap elem lesz
       
       Select objSelect3 = new Select(objdriver.findElement(By.id("prop2")));
       WebElement prop2 = objdriver.findElement(By.id("prop2"));
       
       Select objSelect4 = new Select(objdriver.findElement(By.id("aggProp2")));
       WebElement aggprop2 = objdriver.findElement(By.id("aggProp2"));
       
       List<WebElement> prop1options = prop1.findElements(By.tagName("option"));                    // Letrehoztam egy WebElement elemeket tartalmazo listat, amely a "prop1" osszes opciojat tartalmazza
       List<WebElement> aggprop1options = aggprop1.findElements(By.tagName("option"));              // Letrehoztam egy WebElement elemeket tartalmazo listat, amely a "aggprop1" osszes opciojat tartalmazza
       List<WebElement> prop2options = prop2.findElements(By.tagName("option"));
       List<WebElement> aggprop2options = aggprop2.findElements(By.tagName("option"));
       
       for(int i=0; i<prop1options.size(); i++){                                                    // for ciklus letrehozasa 0-tol a prop1options lista mereteig
           objSelect.selectByIndex(i);                                                              // "prop1" weblap elemet beallitom az i-edik opciojara
        for(int j=0; j<aggprop1options.size(); j++){                                                // for ciklus letrehozasa 0-tol a aggprop1options lista mereteig
            objSelect2.selectByIndex(j);                                                            // "aggprop1" weblap elemet beallitom a j-edik opciojara
            for(int k=0; k<prop2options.size(); k++){
                objSelect3.selectByIndex(k);
                for(int l =0; l<aggprop2options.size(); l++){
                    objSelect4.selectByIndex(l);
                    objdriver.findElement(By.id("groupwiseScatterPlotFormSubmit")).click();                 // Megkeresem az oldalon a "groupwiseScatterPlotFormSubmit" id-val ellatott elemet, majd rakattintunk
                    int sta = isNoDataModalhidden();                                                        // Meghivom az "isNoDataModalHidden()" fuggvenyt az egesz tipusu sta nevu valtozioba
                    System.out.printf("%d, ", sta);                                                         // Ellenorzes celjabol kiiratom a fuggveny eredmenyet
                    if(sta == 0){                                                                           // Feltetel letrehozasa, mely szerint ha sta egyenlo 0-val, akkor
                        Wait wait = new FluentWait(objdriver).withTimeout(30, SECONDS)    
                            .pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);                                                                  // varok 10 masodpercig varunk a hibauzenet kiadasara
                        objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[1]/a")).click(); // Megkeresem az eleresi utvonalon keresztul az adott weblap elemet, majd rakattintok
                        objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                 // varok 10 masodpercet varok a hibauzenet kiadasara
                    }
                    else{                                                                                   // belepunk az else agba
                        objdriver.findElement(By.className("btn btn-default")).click();                     // Ha nem teljesul a feltetel, akkor megkeressuk a hibaablakban a "close" gombot, osztalyneven keresztul, majd rakattintunk
                        
                    }                                                                                       // else ag lezarasa
                }
            }
        }
       }
    }
    
    public static void genewisedistribution(){                                                             // Letrehoztam a genewisedistibution() nevu eljarast
              
       objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[2]/a")).click();          // Megkeresem a "Gene-WiseDistribution" fulet a weboldalon xpath-tal, majd rákattintok
       objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                          // Varok 10 masodpercet
       
       Select objSelect0 = new Select(objdriver.findElement(By.id("propGWDist")));                  // Letrehoztam egy Select tipusu valtozot, amely a "propGWDist" nevu elemet keresi meg a weblapon
       WebElement propGWDist = objdriver.findElement(By.id("propGWDist"));                          // Letrehoztam egy WebElement tipusu valtozot, amely a "propGWDist" nevu weblap elem lesz
       
       Select objSelect1 = new Select(objdriver.findElement(By.id("aggGWDist")));                   // Letrehoztam egy Select tipusu valtozot, amely a "aggGWDist" nevu elemet keresi meg a weblapon
       WebElement aggGWDist = objdriver.findElement(By.id("aggGWDist"));                            // Letrehoztam egy WebElement tipusu valtozot, amely a "aggGWDist" nevu weblap elem lesz
       
       Select objSelect2 = new Select(objdriver.findElement(By.id("genewisePlotType")));
       WebElement gwPlotType = objdriver.findElement(By.id("genewisePlotType"));
       
       List<WebElement> propGWDistOptions = propGWDist.findElements(By.tagName("option"));          // Letrehoztam egy WebElement elemeket tartalmazo listat, amely a "propGWDist" osszes opciojat tartalmazza
       List<WebElement> aggGWDistOptions = aggGWDist.findElements(By.tagName("option"));            // Letrehoztam egy WebElement elemeket tartalmazo listat, amely a "aggGWDist" osszes opciojat tartalmazza
       List<WebElement> gwPlotTypeOptions = gwPlotType.findElements(By.tagName("option"));
       
       for(int i=0; i<propGWDistOptions.size(); i++){                                               // for ciklus letrehozasa 0-tol a propGWDistOptions lista mereteig
           objSelect0.selectByIndex(i);                                                             // "propGWDist" weblap elemet beallitom az i-edik opciojara
           for(int j=0; j<aggGWDistOptions.size(); j++){                                            // for ciklus letrehozasa 0-tol a aggpGWDistOptions lista mereteig
               objSelect1.selectByIndex(j);                                                         // "aggGWDist" weblap elemet beallitom a j-edik opciojara
                for(int k=0; k<gwPlotTypeOptions.size(); k++){
                    objSelect2.selectByIndex(k);
                    int sta = isNoDataModalhidden();                                                        // Meghivom az "isNoDataModalHidden()" fuggvenyt az egesz tipusu sta nevu valtozioba
                    System.out.printf("%d, ", sta);                                                         // Ellenorzes celjabol kiiratom a fuggveny eredmenyet
                    if(sta == 0){                                                                           // Feltetel letrehozasa, mely szerint ha sta egyenlo 0-val, akkor
                        objdriver.findElement(By.id("groupwiseDistributionFormSubmit")).click();             // Megkeresem az oldalon a "groupwiseDistibutionFormSubmit" id-val ellatott elemet, majd rakattintunk
                        objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                  // varok 10 masodpercet
                        objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[2]/a")).click();  // Megkeresem a "Gene-WiseDistribution" fulet a weboldalon xpath-tal, majd rákattintok
                        objdriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);                // varok 10 masodpercet
                    }
                    else{                                                                                   // belepunk az else agba
                        objdriver.findElement(By.className("btn btn-default")).click();                     // Ha nem teljesul a feltetel, akkor megkeressuk a hibaablakban a "close" gombot, osztalyneven keresztul, majd rakattintunk
                        
                    }                                                                                       // else ag lezarasa
                }
            }
        }
    }
    
    public static void cellwisescatterplot(){                                                                      // Letrehozom a "cellwisescatterplot()" nevu eljarast
        
        objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[3]/a")).click();                 // Megkeresem a "Cell-Wise scatterplot" fulet a weboldalon xpath-tal, majd rákattintok
        objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                                 // Varok 10 masodpercet
        
        Select objSelect0 = new Select(objdriver.findElement(By.id("cellwiseProp1")));                      // Letrehoztam egy Select tipusu valtozot, amely a "cellwiseProp1" nevu elemet keresi meg a weblapon
        Select objSelect1 = new Select(objdriver.findElement(By.id("cellwiseProp2")));                      // Letrehoztam egy Select tipusu valtozot, amely a "cellwiseProp2" nevu elemet keresi meg a weblapon
        
        WebElement cellwiseProp1 = objdriver.findElement(By.id("cellwiseProp1"));                           // Letrehoztam egy WebElement tipusu valtozot, amely a "cellwiseProp1" nevu weblap elem lesz
        WebElement cellwiseProp2 = objdriver.findElement(By.id("cellwiseProp2"));                           // Letrehoztam egy WebElement tipusu valtozot, amely a "cellwiseProp2" nevu weblap elem lesz
        
        List<WebElement> cellwiseProp1Options = cellwiseProp1.findElements(By.tagName("option"));           // Letrehoztam egy WebElement elemeket tartalmazo listat, amely a "cellwiseProp1" osszes opciojat tartalmazza
        List<WebElement> cellwiseProp2Options = cellwiseProp2.findElements(By.tagName("option"));           // Letrehoztam egy WebElement elemeket tartalmazo listat, amely a "cellwiseProp2" osszes opciojat tartalmazza
        
        for(int i=0; i < cellwiseProp1Options.size(); i++){                                                 // for ciklus letrehozasa 0-tol a cellwiseProp1Options lista mereteig
            objSelect0.selectByIndex(i);                                                                    // "cellwiseProp1" weblap elemet beallitom az i-edik opciojara
            for(int j=0; j < cellwiseProp2Options.size(); j++){                                             // for ciklus letrehozasa 0-tol a cellwiseProp2Options lista mereteig
               objSelect1.selectByIndex(j);                                                                 // "cellwiseProp2" weblap elemet beallitom a j-edik opciojara
               int sta = isNoDataModalhidden();                                                             // Meghivom az "isNoDataModalHidden()" fuggvenyt az egesz tipusu sta nevu valtozioba
               System.out.printf("%d, ", sta);                                                              // Ellenorzes celjabol kiiratom a fuggveny eredmenyet
                    if(sta == 0){ 
                        objdriver.findElement(By.id("cellwiseGraphSubmit")).click();                         // Megkeresem az oldalon a "cellwiseGraphSubmit" id-val ellatott elemet, majd rakattintunk
                        objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);                  // Varok 10 masodpercet
                        objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[3]/a")).click();  // Megkeresem a "Cell-Wise scatterplot" fulet a weboldalon xpath-tal, majd rákattintok
                        objdriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);                // Varok 10 masodpercet
                }
                    else{                                                                                   // belepunk az else agba
                        objdriver.findElement(By.className("btn btn-default")).click();                     // Ha nem teljesul a feltetel, akkor megkeressuk a hibaablakban a "close" gombot, osztalyneven keresztul, majd rakattintunk
                        
                    }
            }
        }
    }
    
    public static void cellwisedistribution(){
        
        objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[4]/a")).click();
        
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
                    int sta = isNoDataModalhidden();                                                             // Meghivom az "isNoDataModalHidden()" fuggvenyt az egesz tipusu sta nevu valtozioba
                    System.out.printf("%d, ", sta);                                                              // Ellenorzes celjabol kiiratom a fuggveny eredmenyet
                    if(sta == 0){ 
                        objdriver.findElement(By.id("cellwiseDistributionSubmit")).click();
                        objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        objdriver.findElement(By.xpath(".//*[@class='container']/div/ul/li[4]/a")).click();
                        objdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    }
                    else{                                                                                   // belepunk az else agba
                        objdriver.findElement(By.className("btn btn-default")).click();                     // Ha nem teljesul a feltetel, akkor megkeressuk a hibaablakban a "close" gombot, osztalyneven keresztul, majd rakattintunk
                        
                    }
                }
            }
        }
        
       objdriver.close();
     
    }
    public static int isNoDataModalhidden(){                                                                       // fuggveny annak ellenorzesere, hogy a Submit utan biztosan kapunk eredmenyt
        WebElement noDataModal = objdriver.findElement(By.id("noDataModal"));                               // felugro ablak megkeresese
        String state = noDataModal.getAttribute("aria-hidden");                                             // kikerem az "aria-hidden" nevu parameter erteket
        if("false".equals(state)){
            return 1;
        }
        else return 0;
    }
}