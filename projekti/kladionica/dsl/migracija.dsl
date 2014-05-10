module Migracija {

  root Foo {
    String  bar;
    Baz     baz;
    calculated Int quxMigrated from 'it => it.baz.qux';
  }

  entity Baz {
    Int  qux;
  }
}
