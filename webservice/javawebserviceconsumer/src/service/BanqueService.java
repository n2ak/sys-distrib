
package service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BanqueService", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BanqueService {


    /**
     * 
     * @param arg0
     * @return
     *     returns service.Compte
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompte", targetNamespace = "http://service/", className = "service.GetCompte")
    @ResponseWrapper(localName = "getCompteResponse", targetNamespace = "http://service/", className = "service.GetCompteResponse")
    @Action(input = "http://service/BanqueService/getCompteRequest", output = "http://service/BanqueService/getCompteResponse")
    public Compte getCompte(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @return
     *     returns java.util.List<service.Compte>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getComptes", targetNamespace = "http://service/", className = "service.GetComptes")
    @ResponseWrapper(localName = "getComptesResponse", targetNamespace = "http://service/", className = "service.GetComptesResponse")
    @Action(input = "http://service/BanqueService/getComptesRequest", output = "http://service/BanqueService/getComptesResponse")
    public List<Compte> getComptes();

    /**
     * 
     * @param montant
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "convertFromEu2Dh", targetNamespace = "http://service/", className = "service.ConvertFromEu2Dh")
    @ResponseWrapper(localName = "convertFromEu2DhResponse", targetNamespace = "http://service/", className = "service.ConvertFromEu2DhResponse")
    @Action(input = "http://service/BanqueService/convertFromEu2DhRequest", output = "http://service/BanqueService/convertFromEu2DhResponse")
    public double convertFromEu2Dh(
        @WebParam(name = "montant", targetNamespace = "")
        double montant);

}
