public class Cuenta {
    private String usuario;
    private String pass;
    private String sus;
    
    public Cuenta(String usuario, String pass, String sus) {
        this.usuario = usuario;
        this.pass = pass;
        this.sus = sus;
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getSus() {
        return sus;
    }
    public void setSus(String sus) {
        this.sus = sus;
    }


}
