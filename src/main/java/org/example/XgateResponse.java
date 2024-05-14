package org.example;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class XgateResponse {
  @JacksonXmlProperty(localName = "Success")
  private boolean success;

  @JacksonXmlProperty(localName = "ResponseCode")
  private String responseCode;

  @JacksonXmlProperty(localName = "ResponseMessage")
  private String responseMessage;

  @JacksonXmlProperty(localName = "MessageBatchID")
  private String messageBatchID;

  @JacksonXmlProperty(localName = "SessionID")
  private String sessionID;

  @JacksonXmlProperty(localName = "NumberOfMessage")
  private int numberOfMessage;

  @JacksonXmlProperty(localName = "NumberOfSuccess")
  private int numberOfSuccess;

  @JacksonXmlProperty(localName = "NumberOfFailure")
  private int numberOfFailure;

  @JacksonXmlProperty(localName = "ReceiveTime")
  private String receiveTime;

  @JacksonXmlElementWrapper(localName = "ReceiverList")
  @JacksonXmlProperty(localName = "Receiver")
  private List<Receiver> receiverList;

  public static class Receiver {
    @JacksonXmlProperty(localName = "MessageID")
    private String messageID;

    @JacksonXmlProperty(localName = "MessageType")
    private String messageType;

    @JacksonXmlProperty(localName = "MessageLanguage")
    private String messageLanguage;

    @JacksonXmlProperty(localName = "MessageScheduleTime")
    private String messageScheduleTime;

    @JacksonXmlProperty(localName = "TimeToLive")
    private int timeToLive;

    @JacksonXmlProperty(localName = "AreaCode")
    private String areaCode;

    @JacksonXmlProperty(localName = "DestinationCountry")
    private String destinationCountry;

    @JacksonXmlProperty(localName = "MobileNumber")
    private String mobileNumber;

    @JacksonXmlProperty(localName = "OperatorID")
    private String operatorID;

    @JacksonXmlProperty(localName = "MessageBody")
    private String messageBody;

    @JacksonXmlProperty(localName = "ACK")
    private int ack;

    @JacksonXmlProperty(localName = "PartNo")
    private int partNo;

    @JacksonXmlProperty(localName = "Status")
    private String status;

    @Override
    public String toString() {
      return "Receiver{" +
        "messageID='" + messageID + '\'' +
        ", messageType='" + messageType + '\'' +
        ", messageLanguage='" + messageLanguage + '\'' +
        ", messageScheduleTime='" + messageScheduleTime + '\'' +
        ", timeToLive=" + timeToLive +
        ", areaCode='" + areaCode + '\'' +
        ", destinationCountry='" + destinationCountry + '\'' +
        ", mobileNumber='" + mobileNumber + '\'' +
        ", operatorID='" + operatorID + '\'' +
        ", messageBody='" + messageBody + '\'' +
        ", ack=" + ack +
        ", partNo=" + partNo +
        ", status='" + status + '\'' +
        '}';
    }
  }

  @Override
  public String toString() {
    return "XgateResponse{" +
      "success=" + success +
      ", responseCode='" + responseCode + '\'' +
      ", responseMessage='" + responseMessage + '\'' +
      ", messageBatchID='" + messageBatchID + '\'' +
      ", sessionID='" + sessionID + '\'' +
      ", numberOfMessage=" + numberOfMessage +
      ", numberOfSuccess=" + numberOfSuccess +
      ", numberOfFailure=" + numberOfFailure +
      ", receiveTime='" + receiveTime + '\'' +
      ", receiverList=" + receiverList +
      '}';
  }
}
