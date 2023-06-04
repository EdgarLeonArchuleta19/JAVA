package com.admin;

/**
 *
 * @author Arctric
 */
public class datosConexion {
    private String srvIp, bdNom, user, pass, cond;

    public datosConexion(String srvIp, String bdNom, String user, String pass, String cond) {
        this.srvIp = srvIp;
        this.bdNom = bdNom;
        this.user = user;
        this.pass = pass;
        this.cond = cond;
    }

    /**
     * @return the srvIp
     */
    public String getSrvIp() {
        return srvIp;
    }

    /**
     * @param srvIp the srvIp to set
     */
    public void setSrvIp(String srvIp) {
        this.srvIp = srvIp;
    }

    /**
     * @return the bdNom
     */
    public String getBdNom() {
        return bdNom;
    }

    /**
     * @param bdNom the bdNom to set
     */
    public void setBdNom(String bdNom) {
        this.bdNom = bdNom;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the cond
     */
    public String getCond() {
        return cond;
    }

    /**
     * @param cond the cond to set
     */
    public void setCond(String cond) {
        this.cond = cond;
    }
    
    
}
