
    public class Customer {
    private int customerId;
    private String customerName;
    private String custumerContactNumber;
        public Customer(int customerId, String customerName, String custumerContactNumber){
            this.customerId=customerId;
            this.customerName = customerName;
            this.custumerContactNumber = custumerContactNumber;
        }
        void setCustomerId(int customerId){

            this.customerId=customerId;
        }
        void setCustomerName(String customerName){

            this.customerName = customerName;
        }
        void setCustumerContactNumber(String custumerContactNumber){
            this.custumerContactNumber = custumerContactNumber;
        }

        public int getCustomerId() {

            return customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getCustumerContactNumber() {
            return custumerContactNumber;
        }
    }
