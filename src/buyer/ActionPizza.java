// 김홍경
package buyer;

import java.util.ArrayList;
import java.util.Scanner;
import data.*;

public class ActionPizza {

   Pizza pizza;
   ArrayList<Stock> ingredient;

//--------------------------------- 메뉴 화면 출력 ---------------------------------


 //--------------------------------- 메뉴 화면 출력 ---------------------------------

    public void print_PizzaMenu() // 피자 메뉴 화면
    {
       Buyer.cleaner();
       System.out.println("[피자 메뉴 화면]");
       for (int i = 0; i < Buyer.data.getPizza().size(); i++) {
          System.out.printf("%d. %-5s\t  %,36d원\n", (i + 1), Buyer.data.getPizza().get(i).getName(),
                Buyer.data.getPizza().get(i).getPrice());
       }
    }

    public void print_DoughMenu() // 도우 메뉴 화면
    {
       Buyer.cleaner();
       System.out.println("[도우 메뉴 화면]");
       System.out.println("0. 선택완료");
       for (int i = 0; i < Buyer.data.getDough().size(); i++) {
          System.out.printf("%d. %-5s\t   %,29d원  %2d개\n", (i + 1), Buyer.data.getDough().get(i).getName(),
                Buyer.data.getDough().get(i).getPrice(), Buyer.data.getDough().get(i).getNum());
       }
    }
    // "%d. %-5s\t %,36d원\n"

    public void print_IngredientMenu() // 재료 메뉴 화면
    {
       Buyer.cleaner();
       System.out.println("[토핑 메뉴 화면]");
      
       System.out.println("0. 선택완료");
       for (int i = 0; i < Buyer.data.getIngredient().size(); i++) {
          System.out.printf("%d. %-5s\t   %,29d원  %2d개\n", (i + 1), Buyer.data.getIngredient().get(i).getName(),
                Buyer.data.getIngredient().get(i).getPrice(), Buyer.data.getIngredient().get(i).getNum());
       }
    }
//--------------------------------- 미니 쇼핑카트 기능 구현 ---------------------------------

   public void list_Minicart_Pizza() {
      System.out.println(pizza.getName());
   } // 피자 쇼핑카트에 출력

   public void list_Minicart_Dough() {
      if (pizza.getDough() != null)
         System.out.println(pizza.getDough().getName());
   } // 도우 쇼핑카트에 출력

   public void list_Minicart_Ingredient() {
      for (int n = 0; n < ingredient.size(); n++)
         System.out.printf("%5s%4d\n", ingredient.get(n).getName(), ingredient.get(n).getNum());
   } // 토핑을 쇼핑카트에 출력

   public void print_Minicart_Sub() {

      System.out.println(Buyer.printLine);
      list_Minicart_Pizza();
      list_Minicart_Dough();
      list_Minicart_Ingredient();
      System.out.println("피자 총 가격 : " + pizza.getPrice() + " 원");
      System.out.println(Buyer.printLine);
   } // 미니 장바구니 출력

//--------------------------------- 피자 커스터마이징 선택 구현 및 장바구니 출력 ---------------------------------      
   void action() {
      ingredient = new ArrayList<Stock>();
      choice_pizza();
      choice_dough();
      choice_ingredient();
   }

   private void choice_pizza() {
      boolean flag_pizza = true;

      print_PizzaMenu();
      while (flag_pizza) {
         System.out.print(Buyer.printLine + "\n" + Buyer.message_1);
         int str = Buyer.inputInt();

         if (!(str > Buyer.data.getPizza().size())) {
            if (Buyer.data.getPizza().get(str - 1).getNum() != 0) {
               pizza = (Pizza) Buyer.data.getPizza().get(str - 1).clone();
               flag_pizza = false;
            } else
               System.out.println("재고가 부족합니다.");
         }
      }
   }

   private void choice_dough() {
      int str_dough = 1;
      boolean flag_dough;
      while (str_dough != 0) {
         flag_dough = true;
         print_DoughMenu();
         print_Minicart_Sub();
         while (flag_dough) {
            System.out.print(Buyer.message_1);
            str_dough = Buyer.inputInt();
            if (str_dough != 0) {
               if (Buyer.data.getDough().get(str_dough - 1).getNum() != 0) {
                  if (pizza.getDough() != null) {
                     int tmp = pizza.getDough().getPrice();
                     pizza.setDough(Buyer.data.getDough().get(str_dough - 1));
                     pizza.setPrice(pizza.getPrice() - tmp);
                     pizza.setPrice(pizza.getPrice() + Buyer.data.getDough().get(str_dough - 1).getPrice());

                  } else {
                     pizza.setDough(Buyer.data.getDough().get(str_dough - 1));
                     pizza.setPrice(pizza.getPrice() + Buyer.data.getDough().get(str_dough - 1).getPrice());

                  }
                  flag_dough = false;
               } else
                  System.out.println("재고가 부족합니다.");
            } else {
               if (pizza.getDough() != null)
                  flag_dough = false;
               else
                  System.out.println("도우를 선택해주세요.");
            }

         }
      }

   }

   private void choice_ingredient() {
      int str_ingredient = 1;
      boolean flag_ingredient;
      boolean flag_Newingredient;

      while (str_ingredient != 0) {
         flag_ingredient = true;
         print_IngredientMenu();
         print_Minicart_Sub();
         while (flag_ingredient) {
            System.out.print(Buyer.message_1);
            str_ingredient = Buyer.inputInt();
            if (str_ingredient != 0) {
               if (Buyer.data.getIngredient().get(str_ingredient - 1).getNum() != 0) {
                  if (ingredient.size() == 0) {
                     ingredient.add((Stock) (Buyer.data.getIngredient().get(str_ingredient - 1).clone()));
                     pizza.setPrice(
                           pizza.getPrice() + Buyer.data.getIngredient().get(str_ingredient - 1).getPrice());
                  }

                  else {
                     flag_Newingredient = true;
                     for (int n = 0; n < ingredient.size(); n++) {
                        if (Buyer.data.getIngredient().get(str_ingredient - 1).getName()
                              .equals(ingredient.get(n).getName())) {
                           if (ingredient.get(n).getNum() < Buyer.data.getIngredient().get(str_ingredient - 1)
                                 .getNum()) {
                              ingredient.get(n).setNum(ingredient.get(n).getNum() + 1);
                              pizza.setPrice(pizza.getPrice() + ingredient.get(n).getPrice());
                           }
                           flag_Newingredient = false;
                           break;

                        }
                     }
                     if (flag_Newingredient) {
                        ingredient.add((Stock) (Buyer.data.getIngredient().get(str_ingredient - 1).clone()));
                        pizza.setPrice(pizza.getPrice()
                              + Buyer.data.getIngredient().get(str_ingredient - 1).getPrice());
                        break;
                     }
                  }
                  flag_ingredient = false;
               } else {
                  System.out.println("재고가 부족합니다.");
               }
            } else {
               flag_ingredient = false;
            }
         }
      }

      for (int n = 0; n < ingredient.size(); n++) {
         pizza.getIngredient().add(ingredient.get(n));
      } //

      for (int n = 0; n < Buyer.data.getPizza().size(); n++) {
         if (pizza.getName().equals(Buyer.data.getPizza().get(n).getName())) {
            Buyer.data.getPizza().get(n).setNum(Buyer.data.getPizza().get(n).getNum() - 1);

            for (int n1 = 0; n1 < Buyer.data.getDough().size(); n1++) {
               if (pizza.getDough().getName().equals(Buyer.data.getDough().get(n1).getName())) {
                  Buyer.data.getDough().get(n1).setNum(Buyer.data.getDough().get(n1).getNum() - 1);
                  break;
               }
            }

            for (int n2 = 0; n2 < ingredient.size(); n2++) {
               for (int n3 = 0; n3 < Buyer.data.getIngredient().size(); n3++) {
                  if (ingredient.get(n2).getName().equals(Buyer.data.getIngredient().get(n3).getName())) {
                     Buyer.data.getIngredient().get(n3)
                           .setNum(Buyer.data.getIngredient().get(n3).getNum() - ingredient.get(n2).getNum());
                     break;
                  }
               }
            }
         }
      }

      for (int n = 0; n < Buyer.data.getPizza().size(); n++) {
         if (pizza.getName().equals(Buyer.data.getPizza().get(n).getName())) {
            for (int n1 = 0; n1 < Buyer.data.getPizza().get(n).getIngredient().size(); n1++) {
               for (int n2 = 0; n2 < Buyer.data.getIngredient().size(); n2++) {
                  if (Buyer.data.getPizza().get(n).getIngredient().get(n1).getName()
                        .equals(Buyer.data.getIngredient().get(n2).getName())) {
                     Buyer.data.getIngredient().get(n2).setNum(Buyer.data.getIngredient().get(n2).getNum()
                           - Buyer.data.getPizza().get(n).getIngredient().get(n1).getNum());
                  }
               }

            }
            break;
         }

      }
      for (int i = 0; i < Buyer.data.getPizza().size(); i++) {
         if (pizza.getName().equals(Buyer.data.getPizza().get(i).getName())) {
            for (int n = 0; n < Buyer.data.getPizza().get(i).getIngredient().size(); n++) {
               for (int n1 = 0; n1 < pizza.getIngredient().size(); n1++) {
                  if (Buyer.data.getPizza().get(i).getIngredient().get(n).getName()
                        .equals(pizza.getIngredient().get(n1).getName())) {
                     pizza.getIngredient().get(n1).setNum(pizza.getIngredient().get(n1).getNum()
                           + Buyer.data.getPizza().get(i).getIngredient().get(n).getNum());
                     break;
                  }
               }
            }
         }
      }

      Buyer.shoppingCart.getPizza().add(pizza);
      pizza = null;
   }

}