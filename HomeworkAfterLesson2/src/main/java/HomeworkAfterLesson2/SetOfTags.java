package HomeworkAfterLesson2;

public class SetOfTags {

    public SetOfTags() {
    }

    public SetOfTags(String tags) {
    }

    @Override
    public String toString() {
        return "";
    }

    /**
     * Проверка пустое множество
     * @return <tt>true</tt> если множество не содержит ни одного тэга
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Число тэгов в множестве
     * @return число тэгов в множестве
     */
    public int size() {
        return 0;
    }

    /**
     * Очистка множества
     */
    public void clear() {
    }

    /**
     * Добавление <tt>tags</tt> в множество
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean add(String tags) {
        return false;
    }

    /**
     * Проверка на вхождение тегов в множества
     * @return <tt>true</tt> если множество содержит все указанные теги
     */
    public boolean contains(String tags) {
        return false;
    }

    /**
     * Удаление тегов из множества
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean remove(String tags) {
        return false;
    }

    /**
     * Объединение множеств.
     * <p>Добавляет к множеству теги <tt>tags</tt>.
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean union(String tags) {
        return false;
    }

    /**
     * Разность множеств.
     * <p>Удаляет из множества теги <tt>tags</tt>.
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean difference(String tags) {
        return false;
    }

    /**
     * Пересечение множеств.
     * <p>Удаляет из множества теги отсутствующие в <tt>tags</tt>.
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean intersection(String tags) {
        return false;
    }

}
