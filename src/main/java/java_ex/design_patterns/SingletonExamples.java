package java_ex.design_patterns;

public class SingletonExamples {
    public static class EagerInitialized{
        private static EagerInitialized instance = new EagerInitialized();

        private EagerInitialized(){}

        public static EagerInitialized getInstance(){ return instance;}
    }

    public static class StaticBlockInitialized{
        private static StaticBlockInitialized instance;
        static {
            instance = new StaticBlockInitialized();
        }

        private StaticBlockInitialized(){}

        public static StaticBlockInitialized getInstance(){ return instance;}
    }

    public static class LazyInitialization{
        private static LazyInitialization instance;
        private LazyInitialization(){}

        public static LazyInitialization getInstance(){
            if(instance==null){
                instance=new LazyInitialization();
            }
            return instance;
        }
    }

    public static class ThreadSafe{
        private static ThreadSafe instance;
        private ThreadSafe(){}
        public static synchronized ThreadSafe getInstance(){
            if(instance==null){
                instance=new ThreadSafe();
            }
            return instance;
        }
    }

    public static class DoubleLockThreadSafe{
        private static volatile DoubleLockThreadSafe instance;
        private DoubleLockThreadSafe(){}

        public static DoubleLockThreadSafe getInstance(){
            if(instance==null){
                synchronized (DoubleLockThreadSafe.class){
                    if(instance==null){
                        instance = new DoubleLockThreadSafe();
                    }
                }
            }
            return instance;
        }
    }
}
