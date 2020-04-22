package carrepair;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Log_table")
public class Log {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String carno;
        private String carname;
        private String ownername;
        private String status;
        private Long acceptid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(Long acceptid) {
        this.acceptid = acceptid;
    }
}
