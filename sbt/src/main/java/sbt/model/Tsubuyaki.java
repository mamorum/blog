package sbt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tsubuyaki extends TimestampEntity {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long id;

	@NotEmpty
	public String txt;

	@Version
	public long version;
}
