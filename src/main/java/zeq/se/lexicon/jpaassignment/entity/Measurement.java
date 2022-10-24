package zeq.se.lexicon.jpaassignment.entity;

import org.hibernate.hql.internal.ast.util.LiteralProcessor;

public enum Measurement {


      CUP(1," Cup")
    , TBSP(1 , "Tablespoon")
    , TSP(1, "Teaspoon")
    , DL(1,"Deciliter")
      , PCS(1, "Peaces");

    Measurement(int i, String s) {
    }
}

