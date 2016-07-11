/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Dennys
 */
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (value == null) {
            return null;
        } else {
            return value ? "S" : "N";
        }

    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        } else if (value.equals("S")) {
            return true;
        } else if (value.equals("N")) {
            return false;
        } else {
            throw new IllegalStateException("Invalid boolean character: " + value);
        }
    }

}
