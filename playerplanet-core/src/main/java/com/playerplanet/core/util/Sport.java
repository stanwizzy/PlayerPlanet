package com.playerplanet.core.util;


public enum Sport {

        SOCCER("soccer"),BASKETBALL("basketball"),BASEBALL("baseball"),FOOTBALL("football"),COMPOSITE("composite");

        private String description;
        private Sport(String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }

}
