package com.nttdata.entrevista.model;

public enum TipoDocumento {
    CEDULA("Cedula de Ciudadania", "C"),
    PASAPORTE("Pasaporte", "P");

    private String nombreDocumento;
    private String identificacionDocumento;

    TipoDocumento(String nombreDocumento, String identificacionDocumento) {
        this.nombreDocumento = nombreDocumento;
        this.identificacionDocumento = identificacionDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getIdentificacionDocumento() {
        return identificacionDocumento;
    }

    public void setIdentificacionDocumento(String identificacionDocumento) {
        this.identificacionDocumento = identificacionDocumento;
    }
}
