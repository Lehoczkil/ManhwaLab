
docker build -t manhwalab-app:manhwalab -f backend.dockerfile .
docker build -t manhwalab-database:manhwalab-db -f manhwaLabDatabase.dockerfile .
sudo ufw allow 3000
docker-compose up