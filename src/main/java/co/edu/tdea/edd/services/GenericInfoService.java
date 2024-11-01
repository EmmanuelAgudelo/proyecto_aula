package co.edu.tdea.edd.services;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.health_contact.GenericInfo;

public class GenericInfoService {
    private final List<GenericInfo> genericInfoList = new List<>();

    public void addGenericInfo(GenericInfo info) {
        genericInfoList.add(info);
    }

    public GenericInfo findGenericInfo(String code) {
        return genericInfoList.search(new GenericInfo(code, ""));
    }

    public boolean removeGenericInfo(String code) {
        genericInfoList.remove(new GenericInfo(code, ""));
        return false;
    }
}
