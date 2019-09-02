
package com.beitech.informamos.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.beitech.informamos.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Total_QNAME = new QName("http://ws.informamos.beitech.com/", "total");
    private final static QName _TotalResponse_QNAME = new QName("http://ws.informamos.beitech.com/", "totalResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.beitech.informamos.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Total }
     * 
     */
    public Total createTotal() {
        return new Total();
    }

    /**
     * Create an instance of {@link TotalResponse }
     * 
     */
    public TotalResponse createTotalResponse() {
        return new TotalResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Total }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.informamos.beitech.com/", name = "total")
    public JAXBElement<Total> createTotal(Total value) {
        return new JAXBElement<Total>(_Total_QNAME, Total.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TotalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.informamos.beitech.com/", name = "totalResponse")
    public JAXBElement<TotalResponse> createTotalResponse(TotalResponse value) {
        return new JAXBElement<TotalResponse>(_TotalResponse_QNAME, TotalResponse.class, null, value);
    }

}
