module AdressBook {
  root Person {
    String   name;
//    Address  address;
      String  street;
      String  city;
      String  state;
      int     zipcode;

//    calculated String street  from 'it => it.address.street';
//    calculated String city    from 'it => it.address.city';
//    calculated String state   from 'it => it.address.state';
//    calculated Int    zipcode from 'it => it.address.zipcode';
  }

//  value Address {
//    String  street;
//    String  city;
//    String  state;
//    int     zipcode;
//  }
}
