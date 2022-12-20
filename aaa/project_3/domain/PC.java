package domain;


public class PC implements Equipment{

        private String model;
        private String display;  // 显示器名称

        public PC() {

        }

        public PC(String model, String display) {
            this.display = display;
            this.model = model;
        }

        @Override
        public String getDescription() {
            return model + "(" + display + ")";
        }

}
