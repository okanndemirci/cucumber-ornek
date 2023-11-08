Feature: US1004 Amazonda listeden ilk urunun dogru oldugunu test eder

  @wip
  Scenario: TC08 ilk urun ismi arattirdigimiz kelimeyi icermeli

    Given kullanici "amazonUrl" anasayfaya gider
    Then  1 saniye bekler
    Then kullanıcı girişi yapar
    Then 1 saniye bekler
    Then arama kutusuna "Java" yazip, ENTER tusuna basar
    When ilk urunu tiklar
    When  sepete ekler
    Then anasayfaya dönülür
    Then  arama kutusuna "Java yazlimin kalbidir VE HERYERDEDİR" yazip, ENTER tusuna basar
    * ilk urunu tiklar
    And sayfayi kapatir



