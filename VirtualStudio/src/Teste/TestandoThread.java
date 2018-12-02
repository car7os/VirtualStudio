package Teste;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.security.SecureRandom;

//Interface Buffer especifica métodos chamados por Producer e Consumer.
interface Buffer {
  // coloca o valor int no Buffer

  public void blockingPut(int value) throws InterruptedException;

  // retorna o valor int a partir do Buffer
  public int blockingGet() throws InterruptedException;
} // fim da interface Buffer
//------------------------------------------------------------------------------ 
//UnsynchronizedBuffer mantém o inteiro compartilhado que é acessado por
//uma thread produtora e uma thread consumidora.

class UnsynchronizedBuffer implements Buffer {

  private int buffer = -1; // compartilhado pelas threads producer e consumerÿ
  // coloca o valor no buffer

  public void blockingPut(int value) throws InterruptedException {
      System.out.printf("Producer writes\t%2d", value);
      buffer = value;
  }

  // retorna valor do buffer
  public int blockingGet() throws InterruptedException {
      System.out.printf("Consumer reads\t%2d", buffer);
      return buffer;
  }
} // fim da classe UnsynchronizedBuffer
//------------------------------------------------------------------------------ 
//Consumidor com um método run que faz um loop, lendo 10 valores do buffer.

class Consumer implements Runnable {

  private static final SecureRandom generator = new SecureRandom();
  private final Buffer sharedLocation; // referência a objeto compartilhado
  // construtor

  public Consumer(Buffer sharedLocation) {
      this.sharedLocation = sharedLocation;
  }

//lê o valor do sharedLocation 10 vezes e soma os valoresÿ
  public void run() {
      int sum = 0;

      for (int count = 1; count <= 10; count++) {
          // dorme de 0 a 3 segundos, lê o valor do buffer e adiciona a soma
          try {
              Thread.sleep(generator.nextInt(3000));
              sum += sharedLocation.blockingGet();
              System.out.printf("\t\t\t%2d%n", sum);
          } catch (InterruptedException exception) {
              Thread.currentThread().interrupt();
          }
      }

      System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer");
  }
} // fim da classe Consumer
//------------------------------------------------------------------------------ 
//Produtor com um método run que insere os valores de 1 a 10 em buffer.

class Producer implements Runnable {

  private static final SecureRandom generator = new SecureRandom();
  private final Buffer sharedLocation; // referência a objeto compartilhado

  // construtor
  public Producer(Buffer sharedLocation) {
      this.sharedLocation = sharedLocation;
  }

//armazena os valores de 1 a 10 em sharedLocationÿ
  public void run() {
      int sum = 0;

      for (int count = 1; count <= 10; count++) {
          try // dorme de 0 a 3 segundos, então coloca valor em Buffer
          {
              Thread.sleep(generator.nextInt(3000)); // sono aleatório ÿ
              sharedLocation.blockingPut(count); // configura valor no bufferÿ
              sum += count; // incrementa soma de valores
              System.out.printf("\t%2d%n", sum);
          } catch (InterruptedException exception) {
              Thread.currentThread().interrupt();
          }
      }

      System.out.printf("Producer done producing%nTerminating Producer%n");
  }
} // fim da classe Producer
//------------------------------------------------------------------------------ 
//Aplicativo com duas threads que manipulam um buffer não sincronizado.

public class TestandoThread {

  public static void main(String[] args) throws InterruptedException {
      // cria novo pool de threads com duas threads
      ExecutorService executorService = Executors.newCachedThreadPool();

//cria UnsynchronizedBuffer para armazenar ints 
      Buffer sharedLocation = new UnsynchronizedBuffer();

      System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
      System.out.printf("------\t\t-----\t---------------\t---------------%n%n");

      // executar Producer e Consumer, dando a cada um
      // acesso a sharedLocation
      executorService.execute(new Producer(sharedLocation));
      executorService.execute(new Consumer(sharedLocation));

      executorService.shutdown(); // termina o aplicativo quando as tarefas concluem
      executorService.awaitTermination(1, TimeUnit.MINUTES);
  }
} // fim da classe SharedBufferTest
//------------------------------------------------------------------------------ 