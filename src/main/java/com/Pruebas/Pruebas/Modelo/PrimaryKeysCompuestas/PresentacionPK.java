package com.Pruebas.Pruebas.Modelo.PrimaryKeysCompuestas;

import com.Pruebas.Pruebas.Modelo.Calendario;
import com.Pruebas.Pruebas.Modelo.HistoricoGrupo;

public class PresentacionPK {
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((calendario == null) ? 0 : calendario.hashCode());
        result = prime * result + ((historicoGrupo == null) ? 0 : historicoGrupo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PresentacionPK other = (PresentacionPK) obj;
        if (calendario == null) {
            if (other.calendario != null)
                return false;
        } else if (!calendario.equals(other.calendario))
            return false;
        if (historicoGrupo == null) {
            if (other.historicoGrupo != null)
                return false;
        } else if (!historicoGrupo.equals(other.historicoGrupo))
            return false;
        return true;
    }
    private Calendario calendario;
    private HistoricoGrupo historicoGrupo;
    public PresentacionPK() {
    }
    public Calendario getCalendario() {
        return calendario;
    }
    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }
    public HistoricoGrupo getHistoricoGrupo() {
        return historicoGrupo;
    }
    public void setHistoricoGrupo(HistoricoGrupo historicoGrupo) {
        this.historicoGrupo = historicoGrupo;
    }
}
