# ���������� ����������� ����� Node.js ��� ������� �����
FROM node:14-alpine

# ������������� ������� ����������
WORKDIR /app

# �������� package.json � package-lock.json
COPY package*.json ./

# ������������� �����������
RUN npm install

# �������� ��������� �����
COPY . .

# ����������� ���� 3000
EXPOSE 3000

# ��������� ����������
CMD ["npm", "start"]
