
package clientews.servicio;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PersonaServicioImplService", targetNamespace = "http://servicio.sga.gm.com.mx/", wsdlLocation = "http://localhost:8088/PersonaServicioImplService/PersonaServicioImpl?wsdl")
public class PersonaServicioImplService
    extends Service
{

    private final static URL PERSONASERVICIOIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException PERSONASERVICIOIMPLSERVICE_EXCEPTION;
    private final static QName PERSONASERVICIOIMPLSERVICE_QNAME = new QName("http://servicio.sga.gm.com.mx/", "PersonaServicioImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8088/PersonaServicioImplService/PersonaServicioImpl?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PERSONASERVICIOIMPLSERVICE_WSDL_LOCATION = url;
        PERSONASERVICIOIMPLSERVICE_EXCEPTION = e;
    }

    public PersonaServicioImplService() {
        super(__getWsdlLocation(), PERSONASERVICIOIMPLSERVICE_QNAME);
    }

    public PersonaServicioImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PERSONASERVICIOIMPLSERVICE_QNAME, features);
    }

    public PersonaServicioImplService(URL wsdlLocation) {
        super(wsdlLocation, PERSONASERVICIOIMPLSERVICE_QNAME);
    }

    public PersonaServicioImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PERSONASERVICIOIMPLSERVICE_QNAME, features);
    }

    public PersonaServicioImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PersonaServicioImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PersonaServiceWs
     */
    @WebEndpoint(name = "PersonaServicioImplPort")
    public PersonaServiceWs getPersonaServicioImplPort() {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "PersonaServicioImplPort"), PersonaServiceWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PersonaServiceWs
     */
    @WebEndpoint(name = "PersonaServicioImplPort")
    public PersonaServiceWs getPersonaServicioImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicio.sga.gm.com.mx/", "PersonaServicioImplPort"), PersonaServiceWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PERSONASERVICIOIMPLSERVICE_EXCEPTION!= null) {
            throw PERSONASERVICIOIMPLSERVICE_EXCEPTION;
        }
        return PERSONASERVICIOIMPLSERVICE_WSDL_LOCATION;
    }

}
