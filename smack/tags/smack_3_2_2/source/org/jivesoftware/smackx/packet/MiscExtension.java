package org.jivesoftware.smackx.packet;

import org.jivesoftware.smack.packet.PacketExtension;
import org.jivesoftware.smack.provider.PacketExtensionProvider;
import org.xmlpull.v1.XmlPullParser;

/**
 * A packet extension used to advertise the unique ids of the 
 * running conference.
 *
 * @author Martin Sebastian
 */
public class MiscExtension implements PacketExtension
{
    /**
     * XML element name of this packets extension.
     */
    public static final String ELEMENT_NAME = "data";

    /**
     * The namespace that qualifies the XML element of an extension.
     */
    public static final String NAMESPACE = "urn:xmpp:comcast:info";

    private String event;
    private String traceId;
    private String rootNodeId;
    private String childNodeId;
    private String host;
    private String roomToken;
    private String roomTokenExpiryTime;
    private String toRoutingId;

    /*
     * (non-Javadoc)
     * 
     * @see org.jivesoftware.smack.packet.PacketExtension#getElementName()
     */
    public String getElementName() {
        return ELEMENT_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.jivesoftware.smack.packet.PacketExtension#getNamespace()
     */
    public String getNamespace() {
        return NAMESPACE;
    }

    /**
     * Sets the event type in Jitsi Meet conference.
     *
     * @param event value to set.
     */
    public void setEvent(String event)
    {
        this.event = event;
    }

    /**
     * Returns the name of event type of conference.
     */
    public String getEvent()
    {
        return event;
    }

    /**
     * Sets the traceId in Jitsi Meet conference.
     *
     * @param traceId value to set.
     */
    public void setTraceId(String traceId)
    {
        this.traceId = traceId;
    }

    /**
     * Returns the traceId value of conference.
     */
    public String getTraceId()
    {
        return traceId;
    }

    /**
     * Sets the nodeId in Jitsi Meet conference.
     *
     * @param nodeId value to set.
     */
    public void setRootNodeId(String rootNodeId)
    {
        this.rootNodeId = rootNodeId;
    }

    /**
     * Returns the nodeId value of conference.
     */
    public String getRootNodeId()
    {
        return rootNodeId;
    }

    /**
     * Sets the cNodeId in Jitsi Meet conference.
     *
     * @param cNodeId value to set.
     */
    public void setChildNodeId(String childNodeId)
    {
        this.childNodeId = childNodeId;
    }

    /**
     * Returns the cNodeId value of conference.
     */
    public String getChildNodeId()
    {
        return childNodeId;
    }

     /**
     * Sets the  host in Jitsi Meet conference.
     *
     * @param host value to set.
     */
    public void setHost(String host)
    {
        this.host = host;
    }

    /**
     * Returns the nodeId value of conference.
     */
    public String getHost()
    {
        return host;
    }


    /**
     * Sets the roomToken in Jitsi Meet conference.
     *
     * @param roomToken value to set.
     */
    public void setRoomToken(String roomToken)
    {
        this.roomToken = roomToken;
    }

    /**
     * Returns the roomToken value of conference.
     */
    public String getRoomToken()
    {
        return roomToken;
    }

    /**
     * Sets the roomTokenExpiryTime in Jitsi Meet conference.
     *
     * @param roomTokenExpiryTime value to set.
     */
    public void setRoomTokenExpiryTime(String roomTokenExpiryTime)
    {
        this.roomTokenExpiryTime = roomTokenExpiryTime;
    }

    /**
     * Returns the roomTokenExpiryTime value of conference.
     */
    public String getRoomTokenExpiryTime()
    {
        return roomTokenExpiryTime;
    }
    
    /**
     * Sets the toRoutingId in Jitsi Meet conference.
     *
     * @param toRoutingId value to set.
     */
    public String getToRoutingId()
    {
        return toRoutingId;
    }

    /**
     * Returns the roomTokenExpiryTime value of conference.
     */
     public void setToRoutingId(String toRoutingId)
    {
        this.toRoutingId = toRoutingId;
    }
     
    /*
     * (non-Javadoc)
     * 
     * @see org.jivesoftware.smack.packet.PacketExtension#toXML()
     */
    public String toXML() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<").append(getElementName());
        sb.append(" xmlns='").append(getNamespace()).append("' ");

        if(getEvent() != null && !getEvent().equals(""))
            sb.append(" event='").append(getEvent()).append("' ");

        if(getTraceId() != null && !getTraceId().equals(""))
            sb.append(" traceid='").append(getTraceId()).append("' ");

        if(getRootNodeId() != null && !getRootNodeId().equals(""))
            sb.append(" rootnodeid='").append(getRootNodeId()).append("' ");

        if(getChildNodeId() != null && !getChildNodeId().equals(""))
            sb.append(" childnodeid='").append(getChildNodeId()).append("' ");
        
	if(getHost() != null && !getHost().equals(""))
            sb.append(" host='").append(getHost()).append("' ");
	
	if(getRoomToken() != null && !getRoomToken().equals(""))
            sb.append(" roomtoken='").append(getRoomToken()).append("' ");

	if(getRoomTokenExpiryTime() != null && !getRoomTokenExpiryTime().equals(""))
            sb.append(" roomtokenexpirytime='").append(getRoomTokenExpiryTime()).append("' ");
	    
	if(getToRoutingId() != null && !getToRoutingId().equals(""))
            sb.append(" toroutingid='").append(getToRoutingId()).append("' ");
        
	sb.append("/>");
        return sb.toString();
    }

    public static class Provider implements PacketExtensionProvider {

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.jivesoftware.smack.provider.PacketExtensionProvider#parseExtension
         * (org.xmlpull.v1.XmlPullParser)
         */
        public PacketExtension parseExtension(XmlPullParser arg0)
                throws Exception {
            return new MiscExtension();
        }
    }
}
