package com.example.todoapp.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
// import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.Document;

@org.springframework.data.mongodb.core.mapping.Document(collection="books")
public class Todo {
    @Id 
    private String id;

    // @NotBlank // make sure that the todo’s title is not blank
    // @Size(max=100)
    // @Indexed(unique=true) //creates a unique index on title field
    private String title;

    @NotBlank
    @Size(max=100)
    @Indexed(unique=true) 
    private String ticker;

    private Boolean completed = false;
    private Document map;

    public Todo() {
        super();
    }

    // public Todo(String title, Map<String,Document> iMap) {
        //     this.title = title;
        //     this.map = iMap;
        // }
        
    public Todo(Document instrumentData) {
        this.title = (String)instrumentData.get("title");
        setMap((Document)instrumentData.get("finantials"));
    }

    public Document getMap() {
        return map;
    }

    public void setMap(Document iDoc) {
        this.map = iDoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, title='%s', completed='%s']",
                id, title, completed);
    }
}

// package com.example.todoapp.models;

// import org.bson.Document;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.Size;
// import org.springframework.data.mongodb.core.index.Indexed;
// // import static com.example.carlapp.models.ExcelConfig.LAST_Y;

// @org.springframework.data.mongodb.core.mapping.Document(collection="todos")
// public class ExcelSheetDataModel {
    
//     @NotBlank
//     @Size(max=100)
//     @Indexed(unique=true)
//     private String ticker;
//     private Map<String, Document> dataByFiscalQuarter;
//     private Map<String, Document> dataByFiscalYear;
//     private String companyName;
//     private String tickerBase;
//     private String companyDescription;
//     private Double dailyEV;
//     private Double dailyMarketCap;
//     private Map<String, Document> majorShareholders;
//     private Map<String, Double> tradingStatistics;
//     private Document currentValues;
//     // private ExcelConfig config;
//     private Document dailyParams;

//     public ExcelSheetDataModel(Document instrumentData) {
//         // this.config = new ExcelConfig();
        
//         setDataByFiscalYear((Document) instrumentData.get("DataByFiscalYear"));
//         setDataByFiscalQuarter((Document) instrumentData.get("DataByFiscalQuarter"));
//         setCompanyName((String)instrumentData.get("CompanyName"));
//         setCompanyDescription((String)instrumentData.get("CompanyDescription"));
//         String ticker = (String)instrumentData.get("Ticker");
//         setTicker(ticker);
//         setDailyData((Document) instrumentData.get("DailyUpdated"));
//         setShareholders((ArrayList<Document>)instrumentData.get("Top-10-Owners"));
//         setTradingStatistics(instrumentData);
//         setCurrentValues( this.getDataByFiscalQuarter());
//     }

//     private void setCurrentValues(Map<String, Document> dataByFiscalQuarter) {
//         this.currentValues = dataByFiscalQuarter.get("FY2018Q1");
//     }

//     private void setTradingStatistics(Document instrumentData) {
//         this.tradingStatistics = new HashMap<>();
//         Double price52High = (Double)instrumentData.get("Price52WeekHigh");
//         Double price52Low = (Double)instrumentData.get("Price52WeekLow");
//         Document betas = (Document)instrumentData.get("Betas");
//         Double betaWkly3Y = (Double)betas.get("BetaWkly3Y");
//         Document incomeParams = (Document) dataByFiscalYear.get("FY2017").get("IncomeStatement");
//         Double dps = incomeParams.getDouble("DPS");
//         Double sharePrice = this.getDailyParams().getDouble("SharePrice");
//         Double dayVol30 = dailyParams.getDouble("30DayVolume");
//         this.tradingStatistics.put("SharePrice", sharePrice);
//         this.tradingStatistics.put("Price52WeekHigh", price52High);
//         this.tradingStatistics.put("Price52WeekLow", price52Low);
//         this.tradingStatistics.put("BetaWkly3Y", betaWkly3Y);
//         this.tradingStatistics.put("30DayVolume", dayVol30);
//         this.tradingStatistics.put("DivSh", dps);
//         this.tradingStatistics.put("DivYe", dps/sharePrice);
//     }

//     private void setShareholders(ArrayList<Document> document) {
//         Map<String, Document > results = new HashMap<>();
//         for(Document doc : document ) {
//             results.put(doc.getString("Name"), doc);
//         }
//         this.majorShareholders = results;
//     }

//     private void setDailyData(Document dailyParams) {

//         dailyMarketCap = (Double) dailyParams.get("CompanyMarketCap");
//         dailyEV = (Double) dailyParams.get("EV");
//         this.dailyParams = dailyParams;

//     }

//     private void setDataByFiscalQuarter(Document dataByFiscalQuarter) {
//         Map<String, Document > results = new HashMap<>();
//         dataByFiscalQuarter.forEach((k,v) -> {
//             results.put(k, (Document) v);
//         });
//         this.dataByFiscalQuarter = results;
//     }


//     public Map<String, Document> getDataByFiscalYear() {
//         return dataByFiscalYear;
//     }

//     public void setDataByFiscalYear(Document dataByFiscalYear) {
//         Map<String, Document > results = new HashMap<>();
//         dataByFiscalYear.forEach((k,v) -> {
//             results.put(k, (Document) v);
//         });
//         this.dataByFiscalYear = results;
//     }

//     public String getCompanyName() {
//         return companyName;
//     }

//     public void setCompanyName(String companyName) {
//         this.companyName = companyName;
//     }

//     public String getTicker() {
//         return ticker;
//     }

//     public void setTicker(String ticker) {
//         this.ticker = ticker;
//     }

//     public String getTickerBase() {
//         return tickerBase;
//     }

//     public void setTickerBase(String tickerBase) {
//         this.tickerBase = tickerBase;
//     }

//     public String getCompanyDescription() {
//         return companyDescription;
//     }

//     public void setCompanyDescription(String companyDescription) {
//         this.companyDescription = companyDescription;
//     }
//     public String getCompanyFieldValue() {
//         return "COMPANY SNAPSHOT: " + companyName;
//     }

//     public Map<String, Document> getDataByFiscalQuarter() {
//         return dataByFiscalQuarter;
//     }

//     public Double getDailyEV() {
//         return dailyEV;
//     }

//     public Double getDailyMarketCap() {
//         return dailyMarketCap;
//     }

//     public Map<String, Document> getMajorShareholders() {
//         return majorShareholders;
//     }

//     public Map<String, Double> getTradingStatistics() {
//         return tradingStatistics;
//     }

//     public Document getCurrentValues() {
//         return currentValues;
//     }

//     public Document getDailyParams() {
//         return dailyParams;
//     }
// }
