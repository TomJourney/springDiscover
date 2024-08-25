package com.tom.springnote.chapter04.t040303xmlfile;

import com.tom.springnote.chapter04.t0401.INewsListener;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MockCollectoinInjectObject {
    private List<INewsListener> listenerList;
    private Set<INewsListener> listenerSet;
    private Map<String, INewsListener> listenerMap;
    private Properties listenerProps;

    public MockCollectoinInjectObject() {
        // do nothing
    }

    public List<INewsListener> getListenerList() {
        return listenerList;
    }

    public void setListenerList(List<INewsListener> listenerList) {
        this.listenerList = listenerList;
    }

    public Set<INewsListener> getListenerSet() {
        return listenerSet;
    }

    public void setListenerSet(Set<INewsListener> listenerSet) {
        this.listenerSet = listenerSet;
    }

    public Map<String, INewsListener> getListenerMap() {
        return listenerMap;
    }

    public void setListenerMap(Map<String, INewsListener> listenerMap) {
        this.listenerMap = listenerMap;
    }

    public Properties getListenerProps() {
        return listenerProps;
    }

    public void setListenerProps(Properties listenerProps) {
        this.listenerProps = listenerProps;
    }
}
