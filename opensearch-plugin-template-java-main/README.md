# Запуск
Собрать плагин в zip архив:
> ./gradlew bundlePlugin

Установить плагин в opensearch:
> bin\opensearch-plugin.bat install file:///C:/Users/14ery/Downloads/opensearch-p
lugin/opensearch-plugin-template-java-main/build/distributions/statistics-plugin.zip

Запустить opensearch:
> ./bin/opensearch.bat

Сделать запрос в opensearch:
> curl.exe -X POST "http://localhost:9200/_statistics/function-select" -H "Content-Type: a
pplication/json" --data-binary "@\path\to\data.json"

Настроенный архив opensearch с установленным плагин:
> https://drive.google.com/file/d/1vuqs068dIaAIcRgCoN6s_3d2btXADLsu/view?usp=drive_link
