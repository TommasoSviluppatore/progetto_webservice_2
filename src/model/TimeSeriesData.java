package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="TimeSeriesData")
public class TimeSeriesData {
    
    @XmlElement(name="Meta_Data")
    private MetaData metaData; 
    
    @XmlElementWrapper(name="Time_Series")
    @XmlElement(name="Data_Point")
    private ArrayList<DataPoint> dataPoints;

    public TimeSeriesData() {
        dataPoints = new ArrayList<DataPoint>();
    }

    public TimeSeriesData(MetaData metaData) {
        this.metaData = metaData;
        dataPoints = new ArrayList<DataPoint>();
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public ArrayList<DataPoint> getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(ArrayList<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }
}