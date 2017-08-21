
    import java.util.TimerTask
    import java.util.Timer

    object TimeTest {
      implicit def function2TimerTask(f: () => Unit): TimerTask = {
        return new TimerTask {
          def run() = f()
        }
      }

      def main(args : Array[String]) {
        def timerTask() = println("Inside timer task")

        val timer = new Timer()
        timer.schedule(function2TimerTask(timerTask),100, 300)

        Thread.sleep(5000)

        timer.cancel()

      }

    }