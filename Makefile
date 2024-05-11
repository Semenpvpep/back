.PHONY: postgres-init
postgres-init:
	@docker run --rm -d --name postgres-test -p 5433:5432 \
		-e POSTGRES_USER=clinic -e POSTGRES_PASSWORD=foobar postgres

.PHONY: postgres-cli
postgres-cli:
	@docker exec -it postgres-test psql -U clinic
