/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtabla;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ManagerFalso {
   public ArrayList<EsperBean> getEspers(){
       ArrayList <EsperBean> espers= new ArrayList <EsperBean>();
       espers.add(new EsperBean("Ricardo","Red Carmesi Blood","Espada dragonica",19,"21/11/2019"));
       espers.add(new EsperBean("Emily","Fairy Sounds","Sonido",19,"21/11/2019"));
       espers.add(new EsperBean("Percy","Eternun oceon","Espada dragonica",19,"21/11/2019"));
       espers.add(new EsperBean("Nicolas","Ever Winter","Frio",18,"21/11/2019"));
       return espers;
   } 
}
