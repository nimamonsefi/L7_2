package com.company.Model.service;

import com.company.Model.entity.DairyEnt;
import com.company.Model.repository.DairyRep;

import java.util.List;

public class DairyServ {

    private DairyServ(){}

    private static DairyServ dairyServ = new DairyServ();

    public static DairyServ getInstance(){
        return dairyServ;
    }

    public void save(DairyEnt dairyEnt) throws Exception{
        try (DairyRep dairyRep = new DairyRep()){
            dairyRep.insert(dairyEnt);
            dairyRep.commit();
        }
    }

    public void edit(DairyEnt dairyEnt) throws Exception{
        try (DairyRep dairyRep = new DairyRep()){
            dairyRep.update(dairyEnt);
            dairyRep.commit();
        }
    }

    public void remove(long num) throws Exception{
        try (DairyRep dairyRep = new DairyRep()){
            dairyRep.delete(num);
            dairyRep.commit();
        }
    }

    public List<DairyEnt> report() throws Exception{
        List<DairyEnt> dairyEntList;
        try (DairyRep dairyRep = new DairyRep()){
            dairyEntList = dairyRep.select();
        }
        return dairyEntList;
    }
}
