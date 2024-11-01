package co.edu.tdea.edd.model.health_contact;

import co.edu.tdea.edd.estructure.linkedList.singly.List;

public class GenericInfoService {
    private List<GenericInfo> genericInfoList = new List<>();

    public void addGenericInfo(GenericInfo info) {
        genericInfoList.add(info);
    }

    public GenericInfo findGenericInfo(String code) {
        return genericInfoList.search(new GenericInfo(code, ""));
    }

    public boolean removeGenericInfo(String code) {
        return genericInfoList.remove(new GenericInfo(code, ""));
    }
}
