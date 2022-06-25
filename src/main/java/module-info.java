module Bshell {
    requires java.scripting;
    requires jdk.jsobject;
//    requires jdk.hotspot.agent;
    exports com.cqsd.controller;
    exports com.cqsd.api;
    exports com.cqsd.utils;
    exports com.cqsd.utils.juit;
}