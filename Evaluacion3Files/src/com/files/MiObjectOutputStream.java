/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.files;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author dev
 */
public class MiObjectOutputStream  extends ObjectOutputStream{
    public MiObjectOutputStream(OutputStream out) throws IOException{
        super(out);
    }
    protected void writeStreamHeader() throws IOException{
        
    } 
}
