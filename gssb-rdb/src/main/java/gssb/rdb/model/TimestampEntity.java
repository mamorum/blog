package gssb.rdb.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass    // JPAエンティティの親に必要。
public abstract class TimestampEntity {

	public Timestamp updatedTime;
	
	@Column(updatable=false)
	public Timestamp createdTime;
    
    @PrePersist
    public void prePersist() {
    	Timestamp ts = new Timestamp((new Date()).getTime());
    	this.createdTime = ts;
    	this.updatedTime = ts;
    }
    
    @PreUpdate
    public void preUpdate() {
    	this.updatedTime = new Timestamp((new Date()).getTime());
    }
}
