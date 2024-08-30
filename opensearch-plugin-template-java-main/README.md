# Запуск
Собрать плагин в zip архив:
> ./gradlew bundlePlugin

Установить плагин в opensearch:
> bin\opensearch-plugin.bat install file:///C:/Users/14ery/Downloads/opensearch-p
lugin/opensearch-plugin-template-java-main/build/distributions/statistics-plugin.zip

Запустить opensearch:
> ./bin/opensearch.bat

Сделать запрос в opensearch:
> curl.exe -X POST "http://localhost:9200/_statistics/<command>" -H "Content-Type: application/json" --data-binary "@path/to/file.json"
