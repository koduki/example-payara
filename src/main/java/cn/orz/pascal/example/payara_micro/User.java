/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.orz.pascal.example.payara_micro;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;

/**
 *
 * @author koduki
 */
@Data
@Named
@SessionScoped
public class User implements Serializable{
   String name;
   int age;
}
