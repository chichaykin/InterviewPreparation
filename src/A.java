
//class A { //fulfill code 
//    private Thread b;
//    private Thread c;
//
//    public void B(Runnable r) {
//         b = new Thread(r);
//        b.start();
//    }
//
//    public void C(Runnable r) {
//        c = new Thread(() -> {
//            if (b.isAlive()) {
//                try {
//                    b.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            r.run();
//        });
//
//        if (b != null) {
//            c.start();
//        }
//    }
//}