package conexion;

/**
 * Created by admin on 18/11/17.
 */

public class ConfigConexion {
    /**
     * Transición Home -> Detalle
     */
    public static final int CODIGO_DETALLE = 100;

    /**
     * Transición Detalle -> Actualización
     */
    public static final int CODIGO_ACTUALIZACION = 101;
    /**
     * Puerto que utilizas para la conexión.
     * Dejalo en blanco si no has configurado esta carácteristica.
     */
    private static final String PUERTO_HOST = "";
    /**
     * Dirección IP de genymotion o AVD
     */
    private static final String IP = "174.138.62.211";
    /**
     * URLs del Web Service
     */
    public static final String GETuser = "http://" + IP + PUERTO_HOST + "/obtener_usuario.php"; //id:dataversion
    public static final String GETDenuncia = "http://" + IP + PUERTO_HOST + "/obtener_denuncia.php";
    public static final String GETProceso = "http://" + IP + PUERTO_HOST + "/obtener_tipoSangre.php";


    public static final String RegistroUser = "http://" + IP + PUERTO_HOST + "/Registro_INSERT.php";

    /**
     * Clave para el valor extra que representa al identificador de una meta
     */
    public static final String EXTRA_ID = "IDEXTRA";

}
