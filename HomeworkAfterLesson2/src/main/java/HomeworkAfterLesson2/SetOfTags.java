package HomeworkAfterLesson2;

public class SetOfTags {

    public static final String TAGS_DELIMITER = ", ";
    public String TAGS_DELIMITER_MASK = "[\\s;,]+";

    private String tags = "";
    private String TAGS_FRAMING = " ";

    public SetOfTags() {
    }

    public SetOfTags(String tags) {
        add(tags);
    }

    @Override
    public String toString() {
        return tags.replace(TAGS_FRAMING + TAGS_FRAMING, TAGS_DELIMITER).trim();
    }

    /**
     * Проверка пустое множество
     * @return <tt>true</tt> если множество не содержит ни одного тэга
     */
    public boolean isEmpty() {
        return tags.isEmpty();
    }

    /**
     * Число тэгов в множестве
     * @return число тэгов в множестве
     */
    public int size() {
        return (isEmpty() ? 0 : tags.split(TAGS_FRAMING + TAGS_FRAMING).length);
    }

    /**
     * Очистка множества
     */
    public void clear() {
        tags = "";
    }

    /**
     * Добавление <tt>tags</tt> в множество
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean add(String tags) {
        int processed = 0;
        for (String tag : toArray(tags)) {
            if (! this.tags.contains(tag)) {
                this.tags += TAGS_FRAMING + tag + TAGS_FRAMING;
                processed++;
            }
        }
        return processed > 0;
    }

    /**
     * Проверка на вхождение тегов в множества
     * @return <tt>true</tt> если множество содержит все указанные теги
     */
    public boolean contains(String tags) {
        for (String tag : toArray(tags)) {
            if (! this.tags.toLowerCase().contains(TAGS_FRAMING + tag.toLowerCase() + TAGS_FRAMING)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Удаление тегов из множества
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean remove(String tags) {
        int processed = 0;
        for (String tag : toArray(tags)) {
            if (this.tags.contains(tag)) {
                this.tags = this.tags.replace(TAGS_FRAMING + tag + TAGS_FRAMING, "");
                processed++;
            }
        }
        return processed > 0;
    }

    /**
     * Объединение множеств.
     * <p>Добавляет к множеству теги <tt>tags</tt>.
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean union(String tags) {
        return add(tags);
    }

    /**
     * Разность множеств.
     * <p>Удаляет из множества теги <tt>tags</tt>.
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean difference(String tags) {
        return remove(tags);
    }

    /**
     * Пересечение множеств.
     * <p>Удаляет из множества теги отсутствующие в <tt>tags</tt>.
     * @return <tt>true</tt> если множество изменилось
     */
    public boolean intersection(String tags) {
        SetOfTags savedSetOfTags = new SetOfTags(tags);
        int processed = 0;
        for (String tag : toArray(this.tags)) {
            if (! tags.contains(tag)) {
                this.tags = this.tags.replace(" "+tag+" ", "");
                processed++;
            }
        }
        return processed > 0;
    }

    private String[] toArray(String tags) {
        return tags.split(TAGS_DELIMITER_MASK);
    }

}
