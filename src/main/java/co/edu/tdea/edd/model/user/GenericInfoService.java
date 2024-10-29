package co.edu.tdea.edd.model.user;

import co.edu.tdea.edd.estructure.linkedList.singly.List;
import co.edu.tdea.edd.model.GenericInfo;

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
