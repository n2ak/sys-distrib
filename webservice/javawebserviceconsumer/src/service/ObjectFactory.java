
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
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

    private final static QName _ConvertFromEu2DhResponse_QNAME = new QName("http://service/", "convertFromEu2DhResponse");
    private final static QName _GetCompteResponse_QNAME = new QName("http://service/", "getCompteResponse");
    private final static QName _GetCompte_QNAME = new QName("http://service/", "getCompte");
    private final static QName _ConvertFromEu2Dh_QNAME = new QName("http://service/", "convertFromEu2Dh");
    private final static QName _GetComptesResponse_QNAME = new QName("http://service/", "getComptesResponse");
    private final static QName _GetComptes_QNAME = new QName("http://service/", "getComptes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCompte }
     * 
     */
    public GetCompte createGetCompte() {
        return new GetCompte();
    }

    /**
     * Create an instance of {@link GetCompteResponse }
     * 
     */
    public GetCompteResponse createGetCompteResponse() {
        return new GetCompteResponse();
    }

    /**
     * Create an instance of {@link ConvertFromEu2DhResponse }
     * 
     */
    public ConvertFromEu2DhResponse createConvertFromEu2DhResponse() {
        return new ConvertFromEu2DhResponse();
    }

    /**
     * Create an instance of {@link GetComptes }
     * 
     */
    public GetComptes createGetComptes() {
        return new GetComptes();
    }

    /**
     * Create an instance of {@link ConvertFromEu2Dh }
     * 
     */
    public ConvertFromEu2Dh createConvertFromEu2Dh() {
        return new ConvertFromEu2Dh();
    }

    /**
     * Create an instance of {@link GetComptesResponse }
     * 
     */
    public GetComptesResponse createGetComptesResponse() {
        return new GetComptesResponse();
    }

    /**
     * Create an instance of {@link Compte }
     * 
     */
    public Compte createCompte() {
        return new Compte();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertFromEu2DhResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "convertFromEu2DhResponse")
    public JAXBElement<ConvertFromEu2DhResponse> createConvertFromEu2DhResponse(ConvertFromEu2DhResponse value) {
        return new JAXBElement<ConvertFromEu2DhResponse>(_ConvertFromEu2DhResponse_QNAME, ConvertFromEu2DhResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCompteResponse")
    public JAXBElement<GetCompteResponse> createGetCompteResponse(GetCompteResponse value) {
        return new JAXBElement<GetCompteResponse>(_GetCompteResponse_QNAME, GetCompteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getCompte")
    public JAXBElement<GetCompte> createGetCompte(GetCompte value) {
        return new JAXBElement<GetCompte>(_GetCompte_QNAME, GetCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertFromEu2Dh }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "convertFromEu2Dh")
    public JAXBElement<ConvertFromEu2Dh> createConvertFromEu2Dh(ConvertFromEu2Dh value) {
        return new JAXBElement<ConvertFromEu2Dh>(_ConvertFromEu2Dh_QNAME, ConvertFromEu2Dh.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComptesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getComptesResponse")
    public JAXBElement<GetComptesResponse> createGetComptesResponse(GetComptesResponse value) {
        return new JAXBElement<GetComptesResponse>(_GetComptesResponse_QNAME, GetComptesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetComptes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getComptes")
    public JAXBElement<GetComptes> createGetComptes(GetComptes value) {
        return new JAXBElement<GetComptes>(_GetComptes_QNAME, GetComptes.class, null, value);
    }

}
