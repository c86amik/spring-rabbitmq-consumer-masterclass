/**
 * 
 */
package com.springcavaj.rabbitmq.model;

import java.sql.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author springcavaj
 *
 */
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Car.class)
public class Car {
	private String carName;
	private String modelName;
	private String typeOfCar;
	private String carModelNo;
	private Date dateOfManufacture;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getTypeOfCar() {
		return typeOfCar;
	}
	public void setTypeOfCar(String typeOfCar) {
		this.typeOfCar = typeOfCar;
	}
	public String getCarModelNo() {
		return carModelNo;
	}
	public void setCarModelNo(String carModelNo) {
		this.carModelNo = carModelNo;
	}
	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}
	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}
	@Override
	public int hashCode() {
		return Objects.hash(carModelNo, carName, dateOfManufacture, modelName, typeOfCar);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Car))
			return false;
		Car other = (Car) obj;
		return Objects.equals(carModelNo, other.carModelNo) && Objects.equals(carName, other.carName)
				&& Objects.equals(dateOfManufacture, other.dateOfManufacture)
				&& Objects.equals(modelName, other.modelName) && Objects.equals(typeOfCar, other.typeOfCar);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [carName=");
		builder.append(carName);
		builder.append(", modelName=");
		builder.append(modelName);
		builder.append(", typeOfCar=");
		builder.append(typeOfCar);
		builder.append(", carModelNo=");
		builder.append(carModelNo);
		builder.append(", dateOfManufacture=");
		builder.append(dateOfManufacture);
		builder.append("]");
		return builder.toString();
	}
}
