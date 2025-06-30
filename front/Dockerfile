# Используем официальный образ Node.js как базовый образ
FROM node:14-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем package.json и package-lock.json
COPY package*.json ./

# Устанавливаем зависимости
RUN npm install

# Копируем остальные файлы
COPY . .

# Экспонируем порт 3000
EXPOSE 3000

# Запускаем приложение
CMD ["npm", "start"]
